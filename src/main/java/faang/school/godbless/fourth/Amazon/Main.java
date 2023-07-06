package faang.school.godbless.fourth.Amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final int ORDERS_AMOUNT = 100;

    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 1; i <= ORDERS_AMOUNT; i++) {
            futures.add(processor.processOrder(new Order(i, Status.NEW)));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenAccept(v -> System.out.println(processor.getTotalProcessedOrders().get()))
                .join();
    }
}
