package faang.school.godbless.multi_asyn.task7amazon;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        CompletableFuture<Void>[] futures = new CompletableFuture[100];
        for (int i = 0; i < 100; i++) {
            futures[i] = processor.processOrder(new Order(i));
        }

        CompletableFuture.allOf(futures).join();
        System.out.println("Всего обработано заказов: " + processor.getTotalProcessedOrders());

        processor.endProcess();
    }
}
