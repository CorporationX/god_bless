package AmazonOrders;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private static int currentID = 0;
    private int id;
    private String status;

    public Order() {
        this.id = currentID;
        currentID++;
        this.status = "Awaiting";
    }
}
