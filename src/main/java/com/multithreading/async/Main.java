package com.multithreading.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        MasterCardService masterCardService = new MasterCardService();

        ExecutorService service = Executors.newFixedThreadPool(2);
        doAll(masterCardService, service);
        service.shutdown();

    }

    public static void doAll(MasterCardService masterCardService, ExecutorService service)
            throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<Integer> send = CompletableFuture
                .supplyAsync(masterCardService::sendAnalytics, service);
        Future<Integer> pay = service.submit(masterCardService::collectPayment);
        int resultSend = send.get(1, TimeUnit.MINUTES);
        System.out.println(resultSend);
        int resultPay = pay.get(1, TimeUnit.MINUTES);
        System.out.println(resultPay);
    }
}
