package faang.school.godbless.fan_out;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class SquareRequest {
    private static final long MIN_TIMEOUT = 3000L;
    private final Long number;

    public SquareRequest(Long number) {
        this.number = number;
    }

    public void longTimeSquare(ResultConsumer resultConsumer) {
        var randomTimeout = ThreadLocalRandom.current().nextInt(1000);
        try {
            Thread.sleep(MIN_TIMEOUT + randomTimeout);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            resultConsumer.add(number * number);
        }
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executor = Executors.newFixedThreadPool(requests.size());
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (SquareRequest request : requests) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executor);
            futures.add(future);
        }
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));
        try {
            allOf.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        return resultConsumer.getResult();
    }

    public static void launch() {
        List<SquareRequest> requests = new ArrayList<>();
        for (long i = 1; i <= 1000; i++) {
            requests.add(new SquareRequest(i));
        }
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        Long result = fanOutFanIn(requests, resultConsumer);
        System.out.println("Сумма квадратов чисел от 1 до 1000: " + result);
    }

    public static void main(String[] args) {
        launch();
    }
}
