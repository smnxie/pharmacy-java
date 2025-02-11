import java.util.Date;

public class Order {
    private int orderId;
    private String customerName;
    private String medicineName;
    private int quantity;
    private double totalPrice;
    private Date orderDate;

    public Order(int orderId, String customerName, String medicineName, int quantity, double totalPrice, Date orderDate) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.medicineName = medicineName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
    }

    public int getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public String getMedicineName() { return medicineName; }
    public int getQuantity() { return quantity; }
    public double getTotalPrice() { return totalPrice; }
    public Date getOrderDate() { return orderDate; }
}
