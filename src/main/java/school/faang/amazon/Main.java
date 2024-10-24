package school.faang.amazon;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {

    public static void main(String[] args) {
        List<Order> orders = initOrders();

        try (OrderProcessor processor = new OrderProcessor()) {
            processor.processAllOrders(orders).join();
            log.info("Orders processed: {}", processor.getTotalProcessedOrders());
        }
    }

    private static List<Order> initOrders() {
        return List.of(
                new Order(1),
                new Order(2),
                new Order(3)
        );
    }
}
