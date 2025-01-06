package school.faang.task50441amozon;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private final int id;
    private OrderStatus status;

    public Order(int id) {
        this.id = id;
        this.status = OrderStatus.NEW;
    }

    public void changedStatus(OrderStatus newStatus) {
        if (newStatus == null) {
            throw new IllegalArgumentException("Не корректное значение статуса .");
        }
        status = newStatus;
    }
}
