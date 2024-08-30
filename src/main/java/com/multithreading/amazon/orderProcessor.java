package com.multithreading.amazon;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class orderProcessor {
    private final static Random RANDOM = new Random();
    @Getter
    private final AtomicInteger totalProcessorOrders = new AtomicInteger();

    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            orders.add(new Order(i));
        }

        orderProcessor processor = new orderProcessor();
        List<CompletableFuture<Void>> futureList = orders
                .stream()
                .map(processor::processOrder)
                .toList();

        CompletableFuture<Void> future = CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]));
        future.join();
        System.out.println(processor.getTotalProcessorOrders().get());

    }

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(RANDOM.nextInt(1, 6));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            order.setStatus("Обработано");
            totalProcessorOrders.addAndGet(1);
        });
    }
}
