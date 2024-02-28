package faang.school.godbless.multithreading_async.amazon;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;


public class Main {
    public static void main(String[] args) {
        List<Order> orderList = getOrderList();
        List<CompletableFuture<Void>> futureList = orderToFuture(orderList);
        CompletableFuture.allOf(futureList.toArray(CompletableFuture[]::new)).join();
        System.out.println(OrderProcessor.totalProcessedOrders());
    }

    private static List<Order> getOrderList() {
        List<Order> orderList = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            orderList.add(new Order(i, "Ждет обработки"));
        }
        return orderList;
    }

    private static List<CompletableFuture<Void>> orderToFuture(List<Order> orderList){
        return orderList.stream()
                .map(OrderProcessor::processOrder)
                .toList();
    }
}
