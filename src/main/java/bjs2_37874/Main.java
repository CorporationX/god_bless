package bjs2_37874;

import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        List<Order> orders = IntStream.range(0, 30).boxed().map(Order::new).toList();
        new OrderProcessor().processAllOrders(orders);
    }
}
