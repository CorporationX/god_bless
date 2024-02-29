package faang.school.godbless.collectingamazonorders3165;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Amazon {
    static final OrderProcessor ORDER_PROCESSOR = new OrderProcessor();
    static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(15);
    static final List<Order> ORDERS = createOrdersList();
    static List<CompletableFuture<Void>> futureProcessResults = new ArrayList<>();

    public static void main(String[] args) {
        ORDERS.forEach(order -> futureProcessResults.add(ORDER_PROCESSOR.processOrder(order, EXECUTOR)));
        CompletableFuture.allOf(futureProcessResults.toArray(CompletableFuture[]::new))
                .thenRun(EXECUTOR::shutdown)
                .thenRun(() -> System.out.printf("All %d orders are processed",
                        ORDER_PROCESSOR.getTotalProcessedOrders().get()));
    }

    private static List<Order> createOrdersList() {
        List<Order> result = new ArrayList<>();
        for (int i = 0; i < 1_000; i++) {
            result.add(new Order());
        }
        return result;
    }
}
