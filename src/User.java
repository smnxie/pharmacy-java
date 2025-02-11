public class User {
    private int id;
    private String name;
    private String userType;
    private boolean isBlocked;

    public User(int id, String name, String userType, boolean isBlocked) {
        this.id = id;
        this.name = name;
        this.userType = userType;
        this.isBlocked = isBlocked;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getUserType() { return userType; }
    public boolean isBlocked() { return isBlocked; }
}
