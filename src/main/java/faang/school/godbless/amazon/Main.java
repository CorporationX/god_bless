package faang.school.godbless.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) {
        List<Order> orders = generateOrders();

        List<CompletableFuture<Void>> future = orders.stream()
                .map(OrderProcessor::processOrder)
                .toList();

        try {
            CompletableFuture.allOf(future.toArray(CompletableFuture[]::new)).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println("The total Amount of orders processed is " + OrderProcessor.getTotalProcessedOrders());
    }

    public static List<Order> generateOrders() {
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            orders.add(new Order(i));
        }
        return orders;
    }
}
