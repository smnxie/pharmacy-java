import java.util.List;

public interface IMedicineService {
    void addMedicine(Medicine medicine);
    List<Medicine> getAllMedicines();
    boolean purchaseMedicine(String batchNumber);
    boolean updateStock(String batchNumber, int newQuantity); // ✅ Добавлено
}

