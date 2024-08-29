package faang.school.godbless.BJS2_24691;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {

    public static void main(String[] args) {

        OrderProcessor processor = new OrderProcessor();
        List<Order> orders = new ArrayList<>();
        for (long i = 1; i <= 10; i++) {
            orders.add(new Order(i));
        }

        List<CompletableFuture<Order>> futures = orders.stream()
                .map(processor::processOrder)
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        System.out.println("Total orders: " + processor.getTotalProcessedOrders());
    }
}
