package school.faang.stream4.amazonorders;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, "Новый"),
                new Order(2, "Новый"),
                new Order(3, "Новый")
        );

        int prosessedOrders = processor.processAllOrders(orders)
                .thenApply(result -> processor.getTotalProcessedOrders())
                .join().get();

        System.out.printf("Обработано заказов: %d", prosessedOrders);
    }
}
