import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicineService implements IMedicineService {

    @Override
    public void addMedicine(Medicine medicine) {
        String sql = "INSERT INTO medicines (name, manufacturer, batch_number, price, stock_quantity) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseHandler.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, medicine.getName());
            stmt.setString(2, medicine.getManufacturer());
            stmt.setString(3, medicine.getBatchNumber());
            stmt.setDouble(4, medicine.getPrice());
            stmt.setInt(5, medicine.getStockQuantity()); // ✅ Добавлено количество
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Medicine> getAllMedicines() {
        List<Medicine> medicines = new ArrayList<>();
        String sql = "SELECT * FROM medicines";
        try (Connection conn = DatabaseHandler.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                medicines.add(new Medicine(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("manufacturer"),
                        rs.getString("batch_number"),
                        rs.getDouble("price"),
                        rs.getInt("stock_quantity") // ✅ Получаем количество
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicines;
    }

    @Override
    public boolean purchaseMedicine(String batchNumber) {
        String checkStockSQL = "SELECT stock_quantity FROM medicines WHERE batch_number = ?";
        String updateStockSQL = "UPDATE medicines SET stock_quantity = stock_quantity - 1 WHERE batch_number = ? AND stock_quantity > 0";
        try (Connection conn = DatabaseHandler.getConnection();
             PreparedStatement checkStmt = conn.prepareStatement(checkStockSQL);
             PreparedStatement updateStmt = conn.prepareStatement(updateStockSQL)) {
            checkStmt.setString(1, batchNumber);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getInt("stock_quantity") > 0) {
                updateStmt.setString(1, batchNumber);
                return updateStmt.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // ✅ Добавлен метод поиска лекарств по названию
    public List<Medicine> searchMedicine(String query) {
        List<Medicine> result = new ArrayList<>();
        String sql = "SELECT * FROM medicines WHERE LOWER(name) LIKE ?";
        try (Connection conn = DatabaseHandler.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + query.toLowerCase() + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                result.add(new Medicine(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("manufacturer"),
                        rs.getString("batch_number"),
                        rs.getDouble("price"),
                        rs.getInt("stock_quantity") // ✅ Учитываем запасы
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // ✅ Метод обновления количества на складе
    public boolean updateStock(String batchNumber, int newQuantity) {
        String sql = "UPDATE medicines SET stock_quantity = ? WHERE batch_number = ?";
        try (Connection conn = DatabaseHandler.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, newQuantity);
            stmt.setString(2, batchNumber);
            return stmt.executeUpdate() > 0; // ✅ Если хотя бы одна запись обновлена, возвращаем true
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Если произошла ошибка, возвращаем false
    }
}


