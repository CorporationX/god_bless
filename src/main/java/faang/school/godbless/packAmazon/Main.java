package faang.school.godbless.packAmazon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();
        List<CompletableFuture<Void>> allFutures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            allFutures.add(orderProcessor.processOrder(new Order(i, "In progress")));
        }
        CompletableFuture<Void> futureForAll = CompletableFuture.allOf(allFutures.toArray(new CompletableFuture[0]));
        futureForAll.join();
        System.out.println("Общее количество обработанных заказов - " + orderProcessor.getTotalProcessedOrders());
    }
}
