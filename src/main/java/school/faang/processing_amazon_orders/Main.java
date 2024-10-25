package school.faang.processing_amazon_orders;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor(3);

        List<Order> orders = List.of(
                new Order(1, Status.NEW),
                new Order(2, Status.NEW),
                new Order(3, Status.NEW)
        );
        processor.processAllOrders(orders);
        processor.shutdownExecutorService();
    }
}