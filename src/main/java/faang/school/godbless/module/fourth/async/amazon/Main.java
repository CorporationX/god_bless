package faang.school.godbless.module.fourth.async.amazon;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();
        CompletableFuture[] array = Stream.generate(() -> new Order())
            .limit(10)
            .map((order -> orderProcessor.processOrder(order)))
            .toArray(CompletableFuture[]::new);
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(array);
        allFutures.join();
        allFutures.thenRun(() -> log.info("Processed {} orders", orderProcessor.getTotalProcessedOrders().get()));
    }
}
