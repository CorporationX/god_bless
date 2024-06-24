package faang.school.godbless.fan;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class ResultConsumer {
    private final ExecutorService executor;
    private final int num;

    public ResultConsumer(int num) {
        if (num <= 0 && num > 1000) {
            throw new IllegalArgumentException(
                    "In constructor ResultConsumer class apply int > 1000 && int <= 0");
        }
        this.num = num;
        executor = Executors.newFixedThreadPool(num);
    }

    public long fanOutFanIn() {
        AtomicLong atomicLong = new AtomicLong();
        List<CompletableFuture<Void>> futureList = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            int finalInt = i;
            futureList.add(CompletableFuture.supplyAsync(() -> longTimeSquare(finalInt), executor).thenAccept(atomicLong::getAndAdd));
        }
        futureList.forEach(future -> {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                // Когда получается такая болльшая строчка, то ее стоит разрывать или оставлять как есть?
                // Просто когда мы разрывает строку то это делается через конкернацию, следственно дополнительные
                // затраты памяти. Что считается лучшей практикой в током случае?
                throw new RuntimeException("Error while waiting to receive results from asynchronous operations from List in the fanOutFanIn method of the ResultConsumer class", e);
            }
        });
        return atomicLong.get();
    }


    @SneakyThrows
    public long longTimeSquare(int num) {
        Thread.sleep(100);
        return (long) num * num;
    }

    public void shutdownExecutor() {
        executor.shutdown();
    }
}
