package ordersAmazon_1275;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static final int COUNT_ORDERS = 10;

    public static void main(String[] args) {

        List<Order> orders = new ArrayList<>();
        List<CompletableFuture<Integer>> orderFutures = new ArrayList<>();
        OrderProcessor processor = new OrderProcessor(new AtomicInteger(0));

        for (int i = 1; i <= COUNT_ORDERS; i++) {
            orders.add(new Order("ord_" + i, "NEW"));
        }
        System.out.println(orders);

        orders.stream()
                .forEach((order -> orderFutures.add(processor.processOrder(order))));

        CompletableFuture<Void> allFuture = CompletableFuture.allOf(orderFutures.toArray(new CompletableFuture[orderFutures.size()]));
        allFuture.join();
        System.out.println("Общее количество обработанных заказов - " + processor.getTotalProcessedOrders());
    }
}