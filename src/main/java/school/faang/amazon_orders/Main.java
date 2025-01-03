package school.faang.amazon_orders;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = new ArrayList<>();
        IntStream.range(1, 101)
                .forEach(i -> orders.add(new Order(i, OrderStatus.NEW)));



        log.info("Amount of processed orders: {}", processor.getTotalProcessedOrders().get());
    }
}
