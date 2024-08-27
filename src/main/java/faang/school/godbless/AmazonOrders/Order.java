package faang.school.godbless.AmazonOrders;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private int id;
    private String status;

    public Order(int id) {
        this.id = id;
        status = "создан";
    }
}
