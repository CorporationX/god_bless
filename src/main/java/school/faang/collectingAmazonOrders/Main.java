package school.faang.collectingAmazonOrders;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
        List<Order> orders = List.of(
                new Order(1, "Ordered"),
                new Order(2, "Ordered"),
                new Order(3, "Ordered"),
                new Order(4, "Ready")
        );
        processor.processAllOrders(orders);
        System.out.println(processor.getTotalProcessedOrdersInt());
    }
}
