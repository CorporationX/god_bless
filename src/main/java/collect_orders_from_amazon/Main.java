package collect_orders_from_amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
        List<CompletableFuture<Void>> futureOrders = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Order order = new Order(10 + i, "В ожидании.");
            futureOrders.add(processor.processOrder(order));
        }

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futureOrders.toArray(new CompletableFuture[0]));
        allOf.join();

        allOf.thenRun(() -> {
            System.out.println("Все заказы обработаны.");
            System.out.println("Количество обработанных заказов " + processor.getTotalProcessedOrders().get());
        });
    }
}
