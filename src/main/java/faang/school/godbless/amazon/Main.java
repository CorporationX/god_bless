package faang.school.godbless.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        Order orderOne = new Order(1,"unprocessed");
        Order orderTwo = new Order(2,"unprocessed");
        Order orderThree = new Order(3,"unprocessed");
        Order orderFour = new Order(4,"unprocessed");
        OrderProcessor orderProcessor = new OrderProcessor();
        List<Order> orders = List.of(orderOne,orderTwo,orderThree,orderFour);
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        orders.forEach(order -> {
            CompletableFuture<Void> future = CompletableFuture.runAsync(()->{
                try {
                    orderProcessor.processOrder(order);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            futures.add(future);
        });
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allOf.thenRun(()->{
            System.out.println("result is "+orderProcessor.getTotalProcessedOrders());
        });
        try {
            allOf.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
