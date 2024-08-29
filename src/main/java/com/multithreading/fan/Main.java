package com.multithreading.fan;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    public static final int COUNT_REQUEST = 1000;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        launch(resultConsumer);
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {

        //Мой первый вариант, разбирался как работает.
        ExecutorService service = Executors.newFixedThreadPool(requests.size());
        List<CompletableFuture<Void>> futureList = new ArrayList<>();
        for (SquareRequest squareRequest : requests) {
            CompletableFuture<Void> future = CompletableFuture
                    .runAsync(() -> squareRequest
                            .longTimeSquare(resultConsumer), service);
            futureList.add(future);
        }
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]));
        allOf.join();
        service.shutdown();

        //Этот метод подсказали, что можно решить более лаконично. (Хочу оставить, как пример)
     /*   CompletableFuture<Void> future = CompletableFuture.allOf(requests
                .stream()
                .map((squareRequest -> CompletableFuture
                        .runAsync(() -> squareRequest.longTimeSquare(resultConsumer), service)))
                .toArray(CompletableFuture[]::new));

        future.join();*/
        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    public static void launch(ResultConsumer resultConsumer) {
        List<SquareRequest> requests = new ArrayList<>();
        for (long i = 1; i < COUNT_REQUEST; i++) {
            requests.add(new SquareRequest(i));
        }
        log.info("Создал список чисел");

        long result = fanOutFanIn(requests, resultConsumer);
        System.out.println("Результат выполнения: " + result);
    }
}
