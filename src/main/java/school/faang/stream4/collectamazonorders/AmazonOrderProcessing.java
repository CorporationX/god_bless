package school.faang.stream4.collectamazonorders;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AmazonOrderProcessing {
    public static void main(String[] args) {
        ExecutorService workers = Executors.newFixedThreadPool(5);
        OrderProcessor processor = new OrderProcessor(workers);

        // Создание списка заказов
        List<Order> orders = List.of(
                new Order(1, "Новый"),
                new Order(2, "Новый"),
                new Order(3, "Новый")
        );

        // Обработка заказов
        processor.processAllOrders(orders);

        processor.endProcess();
    }
}
