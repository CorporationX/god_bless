package school.faang.sprint4.amazon;

import java.util.List;

public class AmazonOrderProcessing {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, "Новый"),
                new Order(2, "Новый"),
                new Order(3, "Новый")
        );

        processor.processAllOrders(orders);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Interrupt");
        }
    }
}
