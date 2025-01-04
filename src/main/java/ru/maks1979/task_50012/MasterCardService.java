package ru.maks1979.task_50012;

import java.util.concurrent.*;

public class MasterCardService {
    public int collectPayment() {
        try {
            System.out.println("Payment collected");
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public int sendAnalytics() {
        try {
            System.out.println("Analytics sent");
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    public void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future <Integer> future = executor.submit(this::collectPayment);
        CompletableFuture <Integer> future1 = CompletableFuture.supplyAsync(this::sendAnalytics);
        executor.shutdown();

        int analyticResult;
        int paymentResult;
        try {
            analyticResult = future1.get();
            paymentResult = future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Analytics result: " + analyticResult);
        System.out.println("Payment result: " + paymentResult);
    }}
