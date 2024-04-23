package faang.school.godbless.CollectAmazonOrders;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
    private static final int NUM_ORDERS = 50;
    private static final int NUM_THREADS = 10;

    public static void main(String[] args) {
        List<Order> orders = getOrders();
        ExecutorService pool = Executors.newFixedThreadPool(NUM_THREADS);
        OrderProcessor processor = new OrderProcessor(pool);
        List<CompletableFuture<Void>> tasks = orders.stream().map(processor::processOrder).toList();

        pool.shutdown();
        CompletableFuture.allOf(tasks.toArray(CompletableFuture[]::new)).join();
        System.out.println("total orders: " + processor.getTotalProcessedOrders());
    }

    private static List<Order> getOrders() {
        List<Order> orders = new ArrayList<>();
        IntStream.range(0, NUM_ORDERS).forEach(i -> orders.add(new Order()));
        return orders;
    }
}
