package school.faang.s_4_1_amazon_order_fulfillment;

public class Order {
    private int id;
    private Status status;

    public Order(int id, Status status) {
        this.id = id;
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }
}
