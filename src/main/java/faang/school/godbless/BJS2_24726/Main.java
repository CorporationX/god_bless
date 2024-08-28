package faang.school.godbless.BJS2_24726;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        Order orderOne = new Order(1, "IN_WORK");
        Order orderTwo = new Order(2, "IN_WORK");
        Order orderThree = new Order(3, "IN_WORK");

        CompletableFuture<Void> futureOne = CompletableFuture.runAsync(() -> processor.processOrder(orderOne));
        CompletableFuture<Void> futureTwo = CompletableFuture.runAsync(() -> processor.processOrder(orderTwo));
        CompletableFuture<Void> futureThree = CompletableFuture.runAsync(() -> processor.processOrder(orderThree));

        CompletableFuture.allOf(futureOne, futureTwo, futureThree).join();
        int count = processor.getTotalProcessedOrders().get();
        System.out.println("Orders amount: " + count);
    }
}
