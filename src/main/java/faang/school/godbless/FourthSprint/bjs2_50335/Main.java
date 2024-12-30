package faang.school.godbless.FourthSprint.bjs2_50335;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        // Создание списка заказов
        List<Order> orders = List.of(
                new Order(1, "Новый"),
                new Order(2, "Новый"),
                new Order(3, "Новый")
        );

        // Обработка заказов
        processor.processAllOrders(orders);
    }
}
