package faang.school.godbless.kxnvg.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
        List<CompletableFuture<Void>> completableFutures = new ArrayList<>();

        for (int i = 1; i < 11; i++) {
            completableFutures.add(processor.processOrder(new Order(i)));
        }
        CompletableFuture<Void> allOfFutures = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]));
        allOfFutures.join();
        System.out.println(processor.getTotalProcessedOrders().get());
    }
}
