package school.faang.m1.future.amazone;

import java.util.List;

public class AmazonOrderProcessing {
    public static void main(String[] args) {
        try (OrderProcessor processor = new OrderProcessor()) {
            List<Order> orders = List.of(
                    new Order(1, Order.Status.NEW),
                    new Order(2, Order.Status.NEW),
                    new Order(3, Order.Status.NEW)
            );
            processor.processAllOrders(orders); // ожидает завершение всех задач
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
