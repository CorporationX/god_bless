package faang.school.godbless.OrdersInAmazon;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
    private static final int COUNT_THREAD = 4;
    private static final int COUNT_ORDER = 10;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(COUNT_THREAD);

    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();
        orderProcessing(createOrders(COUNT_ORDER), orderProcessor);
        System.out.println(orderProcessor.getTotalProcessedOrders().get());
        executorService.shutdown();
    }

    private static void orderProcessing(List<Order> orderList, OrderProcessor orderProcessor) {
        List<CompletableFuture<Void>> futures = orderList.stream()
                .map(i -> CompletableFuture.runAsync(
                                () -> orderProcessor.processOrder(i), executorService)
                        .handle((result, ex) -> {
                            if (ex != null) {
                                ex.getMessage();
                            }
                            return result;
                        }))
                .toList();
        futures.forEach(CompletableFuture::join);
    }

    private static List<Order> createOrders(int count) {
        return IntStream.rangeClosed(1, count).mapToObj(i -> new Order(i, "Ожидание")).toList();
    }
}
