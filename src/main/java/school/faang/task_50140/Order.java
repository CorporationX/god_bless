package school.faang.task_50140;

import lombok.NonNull;
import lombok.ToString;

@ToString
public class Order {
    private final int id;
    private OrderStatus status;

    public Order(int id, @NonNull OrderStatus status) {
        this.id = id;
        this.status = status;
    }

    public void setStatus(@NonNull OrderStatus status) {
        this.status = status;
    }

    public OrderStatus getStatus() {
        return status;
    }

}
