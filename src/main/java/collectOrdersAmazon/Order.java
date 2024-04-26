package collectOrdersAmazon;

import lombok.Data;

@Data
public class Order {
    private int id;
    private String status;
    private static int counterID = 1;

    public Order() {
        this.id = counterID;
        this.status = "Arrived";
        counterID++;
    }
}
