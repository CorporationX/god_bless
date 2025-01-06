package school.faang.task50441amozon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class AmazonOrderProcessing {
    public static void main(String[] args) {

        OrderProcessor processor = new OrderProcessor();
        List<Order> orders = new ArrayList<>();

        IntStream.range(0, 50).forEach((i) -> {
            orders.add(new Order(i));
        });

        processor.processAllOrders(orders);
    }
}
