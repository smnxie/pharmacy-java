public class Customer extends Person {
    private String customerId;

    public Customer(String name, String contactInfo, String customerId) {
        super(name, contactInfo);
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public void displayInfo() {
        System.out.println("Customer ID: " + customerId + ", Name: " + name + ", Contact: " + contactInfo);
    }
}
