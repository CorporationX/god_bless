package school.faang.bjs_50055;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

class OrderProcessorTest {

    @Test
    void processOrder() {
        OrderProcessor orderProcessor = new OrderProcessor();
        int orderNumbers = 100;
        List<Order> orders = IntStream.range(0, orderNumbers).boxed()
                .map(i -> new Order(i, OrderStatus.NEW))
                .toList();
        orderProcessor.processAllOrders(orders);

        int actual = orderProcessor.getTotalProcessedOrders().get();

        Assertions.assertEquals(orderNumbers, actual);
    }
}