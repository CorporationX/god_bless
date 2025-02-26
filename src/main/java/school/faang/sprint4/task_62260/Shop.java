package school.faang.sprint4.task_62260;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Slf4j
public class Shop {
    @Getter
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(5);
    private static final OrderProcessor ORDER_PROCESSOR = new OrderProcessor();
    private static final List<CompletableFuture<Void>> FUTURES = new ArrayList<>();
    private static final int COUNT_ORDER = 5;

    public static void main(String[] args) {
        IntStream.range(0, COUNT_ORDER)
                .forEach(Shop::createOrders);
//                .mapToObj(num -> new Order())
//                .peek(order -> log.debug("Create order {}", order))
//                .forEach(order -> futures.add(orderProcessor.processOrder(order)));

        CompletableFuture.allOf(FUTURES.toArray(CompletableFuture[]::new))
                .thenAccept(non -> {
                    FUTURES.clear();
                    EXECUTOR.shutdownNow();
                    log.info("All orders completed {}",
                            ORDER_PROCESSOR.getTotalProcessedOrders() == COUNT_ORDER);
                }).join();
    }



    private static void createOrders(int num) {
        FUTURES.add(CompletableFuture.runAsync(() -> {
            Order order = new Order();
            log.debug("Create order {}", order);
            ORDER_PROCESSOR.processOrder(order);
        }, EXECUTOR));
    }
}
