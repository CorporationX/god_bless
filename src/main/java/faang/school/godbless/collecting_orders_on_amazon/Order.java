package faang.school.godbless.collecting_orders_on_amazon;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private final int id;
    private String status;

    public Order(int id) {
        this.id = id;
        this.status = "Доступен для обработки";
    }
}
