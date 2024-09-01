package faang.school.godbless.sprint4.amazon_orders;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
        List<CompletableFuture<Void>> futures = LongStream.rangeClosed(1, 1000)
                .mapToObj(Order::new)
                .map(processor::processOrder)
                .toList();

        processor.shutdownExecutor();
        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).join();
        System.out.println("Total orders processed: " + processor.getTotalProcessed().intValue());
    }
}
