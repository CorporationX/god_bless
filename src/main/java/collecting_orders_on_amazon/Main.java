package collecting_orders_on_amazon;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = IntStream.rangeClosed(1, 10)
                .mapToObj(Order::new)
                .toList();
        OrderProcessor orderProcessor = new OrderProcessor();
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(orderProcessor::processOrder)
                .toList();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        System.out.println("Всего обработано заказов: " + orderProcessor.getTotalProcessedOrders());
    }
}
