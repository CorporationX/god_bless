package faang.school.godbless.multithreading.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static List<Order> generateOrderList(int size) {
        List<Order> orders = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            int complexity = ThreadLocalRandom.current().nextInt(1000, 3000);
            orders.add(new Order(i, false, complexity));
        }
        return orders;
    }

    public static void main(String[] args) {
        List<Order> orders = generateOrderList(20);

        OrderProcessor processor = new OrderProcessor();
        var completableFutureList = orders.stream()
                .map(processor::processOrder)
                .toList();

        CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[0]))
                .join();

        System.out.printf("Total processed orders is %d\n", processor.getTotalProcessedOrders().get());
    }
}
