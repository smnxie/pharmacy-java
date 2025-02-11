public class Employee extends Person {
    private String employeeId;
    private String position;

    public Employee(String name, String contactInfo, String employeeId, String position) {
        super(name, contactInfo);
        this.employeeId = employeeId;
        this.position = position;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public void displayInfo() {
        System.out.println("Employee ID: " + employeeId + ", Name: " + name + ", Position: " + position);
    }
}
