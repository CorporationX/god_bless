package AmazonOrders;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        OrderProcessor orderProcessor = new OrderProcessor();

        for (int i = 0; i < 1000; i++) {
            orders.add(new Order());
        }

        List<CompletableFuture<Integer>> futers;

        //для каждого ордера запустить processOrder
        futers = orders.stream().map(orderProcessor::processOrder).toList();
        //поместить полученные фучеры в один общий методом allOf
        CompletableFuture<Void> allFuters = CompletableFuture.allOf(futers.toArray(new CompletableFuture[0]));
        allFuters.join();

        System.out.println(orderProcessor.getTotalProcessedOrders());
    }
}
