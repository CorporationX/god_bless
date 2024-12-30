package school.faang.bjs250160;

import java.util.List;

public class AmazonProcessingOrder {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();

        List<Order> orders = List.of(new Order(1, OrderStatus.NEW),
                new Order(2, OrderStatus.NEW),
                new Order(3, OrderStatus.NEW));

       orders.forEach(orderProcessor::processOrder);
       orderProcessor.totalProcess();
    }
}
