package school.faang.collect_orders_from_amazon;

import java.util.List;

public class AmazonOrderProcessing {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
        List<Order> orders = List.of(
                new Order(1, "Новый"),
                new Order(2, "Новый"),
                new Order(3, "Новый")
        );
        System.out.println(orders);
        System.out.println(processor.processAllOrders(orders).join());

    }
}
