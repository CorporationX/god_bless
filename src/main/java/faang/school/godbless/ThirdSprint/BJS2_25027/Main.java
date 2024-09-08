package faang.school.godbless.ThirdSprint.BJS2_25027;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        CompletableFuture<Void> firstOrder = processor.processOrder(new Order());
        CompletableFuture<Void> secondOrder = processor.processOrder(new Order());
        CompletableFuture<Void> thirdOrder = processor.processOrder(new Order());

        CompletableFuture.allOf(firstOrder, secondOrder, thirdOrder).join();
        System.out.println(processor.getTotalProcessedOrders().get());
    }
}
