package faang.school.godbless.sprint5.collectOrders;

import faang.school.godbless.sprint5.collectOrders.classes.Order;
import faang.school.godbless.sprint5.collectOrders.classes.OrderProcess;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        OrderProcess orderProcess = new OrderProcess();
        List<CompletableFuture<Order>> futureList = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            futureList.add(
                    orderProcess.processOrder(new Order())
            );
        }

        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]))
                .join();

        System.out.println(orderProcess.getTotalProcessedOrders());
    }
}
