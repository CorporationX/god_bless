package faang.school.godbless.collect_orders_amazon;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        List<Order> orderList = getOrderList();
        OrderProcessor orderProcessor = new OrderProcessor();

        List<CompletableFuture<Void>> futureOrderList = orderList.stream().map(orderProcessor::processOrder).toList();

        CompletableFuture<Void> allOfFutureOrders =
                CompletableFuture.allOf(futureOrderList.toArray(CompletableFuture[]::new));

        allOfFutureOrders.thenRun(orderProcessor::showTotalProcessedOrdersNumber).join();
    }

    private static List<Order> getOrderList() {
        return List.of(
                new Order(1, "Game"), new Order(2, "Water"), new Order(3, "Paper"),
                new Order(4, "Book"), new Order(5, "Bottle"), new Order(6, "Phone"),
                new Order(7, "Speaker"), new Order(8, "Joystick"), new Order(9, "Mouse")
        );
    }
}