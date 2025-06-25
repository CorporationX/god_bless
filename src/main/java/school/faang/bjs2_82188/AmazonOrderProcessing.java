package school.faang.bjs2_82188;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@Slf4j
public class AmazonOrderProcessing {
    private static final int ORDERS_LIMIT = 10;
    private static final long POOL_AWAIT_TIMEOUT = 10;
    private static ExecutorService fixedPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor(fixedPool);

        List<Order> orders = Stream.generate(Order::new).limit(ORDERS_LIMIT).toList();
        List<CompletableFuture<Void>> futures = orders.stream().map(orderProcessor::processOrder).toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        fixedPool.shutdown();
        try {
            if (!fixedPool.awaitTermination(POOL_AWAIT_TIMEOUT, TimeUnit.SECONDS)) {
                log.info("Еще не все заказы обработаны");
                fixedPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Поток был прерван", e);
            Thread.currentThread().interrupt();
            fixedPool.shutdownNow();
        }

        log.info("Обработано заказов: {}", OrderProcessor.getTotalProcessedOrders());
    }
}
