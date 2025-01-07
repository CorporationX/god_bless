package faang.school.godbless.FourthSprint.bjs2_50335;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, Status.NEW),
                new Order(2, Status.NEW),
                new Order(3, Status.NEW)
        );

        processor.processAllOrders(orders);
    }
}
