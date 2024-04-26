package collectOrdersAmazon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
        List<CompletableFuture<Order>> orders = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            orders.add(processor.processOrder(new Order()));
        }

        orders.forEach(CompletableFuture::join);
        System.out.println("Processed orders: " + processor.getTotalProcessedOrder().get());
    }
}
