package school.faang.сollectOrdersAmazon;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, "Новый"),
                new Order(2, "Новый"),
                new Order(3, "Новый"),
                new Order(4, "Отменено")
        );

        processor.processAllOrders(orders);
    }
}
