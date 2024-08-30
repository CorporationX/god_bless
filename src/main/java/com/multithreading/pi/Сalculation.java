package com.multithreading.pi;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;


@Slf4j
public class Сalculation {
    private final ExecutorService service = Executors.newFixedThreadPool(8);
    private final AtomicInteger inside = new AtomicInteger();
    private final AtomicInteger all = new AtomicInteger();
    private final int countPoints;
    private final int raduis;

    public Сalculation(int countPoints, int raduis) {
        this.countPoints = countPoints;
        this.raduis = raduis;
    }

    public CompletableFuture<Point> generatePoints() {
        return CompletableFuture.supplyAsync(() -> {
            double x = ThreadLocalRandom.current().nextDouble(0.0, 1.0);
            double y = ThreadLocalRandom.current().nextDouble(0.0, 1.0);
            return new Point(x, y);
        }, service);
    }

    public double getNumberPi() {
        List<CompletableFuture<Point>> futureList = IntStream.range(0, countPoints)
                .parallel()
                .mapToObj(fun -> generatePoints())
                .toList();

        CompletableFuture<Void> allPoints = CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]));
        allPoints.thenRun(() -> {
            futureList.forEach(point -> {
                try {
                    double x = Math.pow(point.get().getAxisX(), 2);
                    double y = Math.pow(point.get().getAxisY(), 2);
                    if (x + y <= Math.pow(raduis, 2)) {
                        inside.addAndGet(1);
                    }
                    all.addAndGet(1);
                } catch (InterruptedException | ExecutionException e) {
                    Thread.currentThread().interrupt();
                    log.error("Error = {}", e.getMessage());
                }
            });
        }).join();

        service.shutdown();
        return 4 * inside.doubleValue() / all.doubleValue();
    }
}
