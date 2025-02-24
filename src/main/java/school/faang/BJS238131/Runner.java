package school.faang.BJS238131;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
        List<Order> orders = List.of(
                new Order(1, "Новый"),
                new Order(2, "Новый"),
                new Order(3, "Новый")
        );
        processor.processAllOrders(orders);
        processor.shutDown();
    }
}
