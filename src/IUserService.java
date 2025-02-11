import java.util.List;

public interface IUserService {
    void addUser(User user);
    boolean blockUser(String name);
    List<User> getAllUsers();
}

