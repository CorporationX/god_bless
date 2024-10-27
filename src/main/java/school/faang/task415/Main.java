package school.faang.task415;

import school.faang.task415.orders.Order;
import school.faang.task415.orders.OrderProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
        List<CompletableFuture<Void>> future = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Order order = new Order(i, "Не обработанно");
            future.add(CompletableFuture.runAsync(() -> processor.processOrder(order)));
        }

        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(future.toArray(new CompletableFuture[0]));
        completableFuture.join();

        System.out.println("Обработанно заказов " + processor.getTotalProcessedOrders().get());

    }
}
