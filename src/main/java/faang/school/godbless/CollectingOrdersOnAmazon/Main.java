package faang.school.godbless.CollectingOrdersOnAmazon;

import java.util.List;

import static faang.school.godbless.CollectingOrdersOnAmazon.OrderStatus.*;

public class Main {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();

        getOrders().forEach(orderProcessor::processOrder);
        orderProcessor.waitingAllOrdersProcessed();
        OrderProcessor.shutdownOrderProcessor();
    }

    public static List<Order> getOrders() {
        return List.of(
                new Order("1", NEW),
                new Order("2", NEW),
                new Order("3", NEW),
                new Order("4", NEW),
                new Order("5", NEW),
                new Order("6", NEW),
                new Order("7", NEW),
                new Order("8", NEW)
        );
    }
}
