package school.faang.collectamazon;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order("Новый"),
                new Order("Новый"),
                new Order("Новый")
        );

        List<CompletableFuture<Void>> result = processor.processAllOrders(orders);

        log.info(String.valueOf(result.size()));
    }
}
