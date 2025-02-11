public class Medicine {
    private int id;
    private String name;
    private String manufacturer;
    private String batchNumber;
    private double price;
    private int stockQuantity; // ✅ Новое поле для отслеживания запасов

    public Medicine(int id, String name, String manufacturer, String batchNumber, double price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.batchNumber = batchNumber;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getManufacturer() { return manufacturer; }
    public String getBatchNumber() { return batchNumber; }
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}


