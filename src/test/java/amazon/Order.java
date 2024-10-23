package amazon;

public class Order {
    private int id;
    private OrderStatus status;

    public Order(int id) {
        this.id = id;
        this.status = OrderStatus.NEW;
    }

    public int getId() {
        return id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
