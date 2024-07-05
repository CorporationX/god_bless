package faang.school.godbless.amazon;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger();

    public CompletableFuture<Void> processOrder(Order order){
        if(!order.getStatus().equals("Обработано")){
            return CompletableFuture.runAsync(()->{
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                order.setStatus("Обработано");
                totalProcessedOrders.incrementAndGet();
            });
        } else  throw new RuntimeException("Заказ уже обработан");
    }

    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();
        Order order1 = new Order(1,"");
        Order order2 = new Order(2,"");
        Order order3 = new Order(3,"");
        Order order4 = new Order(4,"");
        Order order5 = new Order(5,"");
        Order order6 = new Order(6,"");
        CompletableFuture<Void> future1 = orderProcessor.processOrder(order1);
        CompletableFuture<Void> future2 = orderProcessor.processOrder(order2);
        CompletableFuture<Void> future3 = orderProcessor.processOrder(order3);
        CompletableFuture<Void> future4 = orderProcessor.processOrder(order4);
        CompletableFuture<Void> future5 = orderProcessor.processOrder(order5);
        CompletableFuture<Void> future6 = orderProcessor.processOrder(order6);
        CompletableFuture.allOf(future1, future2, future3, future4, future5, future6).join();
        System.out.println(orderProcessor.totalProcessedOrders.get());
    }
}
