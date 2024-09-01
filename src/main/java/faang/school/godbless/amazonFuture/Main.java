package faang.school.godbless.amazonFuture;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();

        CompletableFuture.allOf(
                IntStream.range(1, 101)
                        .mapToObj(Order::new)
                        .map(orderProcessor::processOrder)
                        .toArray(CompletableFuture[]::new)
        ).join();

        orderProcessor.printProcessedOrders();
    }
}
