package newPackage;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@ToString
public class ResultConsumer {
    private final AtomicLong sumOfSquaredNumbers;

    ResultConsumer(Long init) {
        sumOfSquaredNumbers = new AtomicLong(init);
    }

    public Long add(final Long num) {
        return sumOfSquaredNumbers.addAndGet(num);
    }

    public static AtomicLong fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executorService = Executors.newFixedThreadPool(requests.size());
        for (SquareRequest request : requests) {
            CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executorService);
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(8000, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            throw new RuntimeException(e);
        }
        return resultConsumer.sumOfSquaredNumbers;
    }

    public void launch() {
        List<SquareRequest> requests = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            requests.add(new SquareRequest((long) i));
        }
        fanOutFanIn(requests, ResultConsumer.this);
        System.out.println(sumOfSquaredNumbers);
    }
}
