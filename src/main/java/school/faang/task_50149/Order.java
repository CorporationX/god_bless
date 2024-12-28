package school.faang.task_50149;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private int id;
    private StatusOrder status;

    public Order(int id) {
        this.id = id;
        this.status = StatusOrder.NEW;
    }

    public void changeStatus(StatusOrder newStatus) {
        if (newStatus == null) {
            throw new IllegalArgumentException("Некорретное значение статуса!");
        }

        status = newStatus;
    }
}
