package faang.school.godbless.bjs2_5940;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {

    private int id;
    private StatusOrder status = StatusOrder.NEW;

    public Order(int id) {
        this.id = id;
    }
}
