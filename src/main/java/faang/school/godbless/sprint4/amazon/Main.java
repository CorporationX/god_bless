package faang.school.godbless.sprint4.amazon;


import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
       OrderProcessor processor = new OrderProcessor();

       Order order = new Order(1, Status.PROSESSING);
       Order order2 = new Order(2, Status.PROSESSING);
       Order order3 = new Order(3, Status.PROSESSING);

       processor.processOrder(order);
       processor.processOrder(order2);
       processor.processOrder(order3);

       System.out.println(processor.getTotalProcessedOrders());

    }
}
