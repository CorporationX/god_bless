package school.faang.amazon_orders;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = new CopyOnWriteArrayList<>();
        IntStream.range(1, 21)
                .forEach(i -> orders.add(new Order(i, OrderStatus.NEW)));

        processor.processAllOrders(orders);
        log.info("Amount of processed orders: {}", processor.getTotalProcessedOrders().get());
    }
}