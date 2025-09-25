package school.faang.multithreading.async.bjs2_93192;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Order {
    private int id;
    private OrderStatus status;

    void statusChange(Order order, OrderStatus newOrderStatus) {
        if (order.getStatus() == OrderStatus.NEW) {
            order.setStatus(newOrderStatus);
        }
    }
}
