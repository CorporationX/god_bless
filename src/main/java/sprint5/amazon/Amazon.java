package sprint5.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Amazon {
    private static final List<Order> ORDERS = Arrays.asList(new Order(0), new Order(1), new Order(2), new Order(3),
            new Order(4), new Order(5), new Order(6), new Order(7), new Order(8), new Order(9));

    public static void main(String[] args) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        OrderProcessor orderProcessor = new OrderProcessor();
        System.out.println(ORDERS);

        for (Order order : ORDERS) {
            futures.add(orderProcessor.processOrder(order));
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        System.out.println(ORDERS);
    }
}
