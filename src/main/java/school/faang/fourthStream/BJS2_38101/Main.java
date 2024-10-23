package school.faang.fourthStream.BJS2_38101;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1),
                new Order(2),
                new Order(3)
        );

        processor.processAllOrders(orders);
    }
}
