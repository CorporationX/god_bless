package school.faang.bjs2_38143;

import java.util.List;

import static school.faang.bjs2_38143.Order.Status.COMPLETED;
import static school.faang.bjs2_38143.Order.Status.NEW;
import static school.faang.bjs2_38143.Order.Status.PROCESSED;

public class Main {

    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, NEW),
                new Order(2, NEW),
                new Order(3, PROCESSED),
                new Order(4, NEW),
                new Order(5, NEW),
                new Order(6, COMPLETED),
                new Order(7, NEW)
        );

        processor.processAllOrder(orders);
    }
}
