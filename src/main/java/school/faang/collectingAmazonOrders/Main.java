package school.faang.collectingAmazonOrders;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
        List<Order> orders = List.of(
                new Order(1, Statuses.ORDERED),
                new Order(2, Statuses.ORDERED),
                new Order(3, Statuses.CANCELED),
                new Order(4, Statuses.READY)
        );
        processor.processAllOrders(orders);
        System.out.println(processor.getTotalProcessedOrdersInt());
    }
}
