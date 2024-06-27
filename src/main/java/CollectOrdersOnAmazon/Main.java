package CollectOrdersOnAmazon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();
        int amountOrders = 15;
        List<Order> orders = createOrders(amountOrders);

        List<CompletableFuture<Void>> allFutureOrders = orders.stream()
                .map(orderProcessor::processOrder)
                .toList();
        CompletableFuture.allOf(allFutureOrders.toArray(new CompletableFuture[0])).join();

        System.out.println("Total orders processed " + orderProcessor.getTotalProcessedOrders());
    }

    public static List<Order> createOrders(int orders) {
        List<Order> result = new ArrayList<>();
        for (int i = 1; i <= orders; i++) {
            result.add(new Order(i, "Waiting for processing"));
        }
        return result;
    }
}