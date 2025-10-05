package school.faang.bjs2_93202;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderProcessor proc = new OrderProcessor();

        List<Order> orders = List.of(new Order(1, "Created"),
                new Order(2, "Created"),
                new Order(3, "Created"),
                new Order(4, "Created"),
                new Order(5, "Created"));

        proc.processAllOrders(orders);
        proc.exShutdown();
    }
}
