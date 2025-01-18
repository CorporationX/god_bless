package collect_amazon_orders;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private final int id;
    private String status;

    public Order(String status, int id) {
        this.status = status;
        this.id = id;
    }
}
