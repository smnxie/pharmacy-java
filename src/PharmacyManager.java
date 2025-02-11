import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PharmacyManager {
    private List<Medicine> medicines;

    public PharmacyManager() {
        this.medicines = new ArrayList<>();
    }

    public void addMedicine(Medicine medicine) {
        medicines.add(medicine);
    }

    public List<Medicine> getAllMedicines() {
        return medicines;
    }

    public boolean purchaseMedicine(String name) {
        Iterator<Medicine> iterator = medicines.iterator();
        while (iterator.hasNext()) {
            Medicine medicine = iterator.next();
            if (medicine.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}

