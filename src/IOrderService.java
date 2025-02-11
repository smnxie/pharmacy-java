import java.util.List;

public interface IOrderService {
    void placeOrder(Order order);
    List<Order> getAllOrders();
}
