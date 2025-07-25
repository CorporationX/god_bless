package school.faang.s_4_1_amazon_order_fulfillment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Order order1 = new Order(24990, Status.PENDING);
        Order order2 = new Order(24990, Status.PENDING);
        Order order3 = new Order(24990, Status.PENDING);
        Order order4 = new Order(24990, Status.PENDING);
        Order order5 = new Order(24990, Status.PENDING);
        Order order6 = new Order(24990, Status.PENDING);
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = new ArrayList<>(Arrays.asList(
                order1,
                order2,
                order3,
                order4,
                order5,
                order6
        ));

        CompletableFuture<Void> ordersFuture = processor.processOrders(orders);
        ordersFuture.thenRun(processor::showTotalProcessedOrders).join();
        processor.shutdown();
        System.out.println(order4.getStatus());
    }
}
