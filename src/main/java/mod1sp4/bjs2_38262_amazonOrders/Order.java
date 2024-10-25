package mod1sp4.bjs2_38262_amazonOrders;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Order {
    private int id;
    private Status status;
}