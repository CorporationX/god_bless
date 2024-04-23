package faang.school.godbless.CollectAmazonOrders;

import lombok.Data;

@Data
public class Order {
    private static int idCounter = 0;
    private int id = ++idCounter;
    private Status status = Status.PENDING;
}
