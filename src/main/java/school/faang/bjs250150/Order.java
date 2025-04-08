package school.faang.bjs250150;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Order {

    private int id;

    @Setter
    private OrderStatus status;

    public Order(int id, OrderStatus status) {
        if (id < 0 || id == 0) {
            log.error("Order ID cannot be negative or zero");
            throw new IllegalArgumentException("Order ID cannot be negative or zero");
        }
        this.id = id;
        this.status = status;
    }
}