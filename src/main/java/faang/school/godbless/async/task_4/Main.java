package faang.school.godbless.async.task_4;

import faang.school.godbless.async.task_4.math.SquareRequest;
import faang.school.godbless.async.task_4.util.ResultConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final long FIRST_NUMBER = 1;
    private static final long LAST_NUMBER = 1000L;

    public static void main(String[] args) {
        launch(FIRST_NUMBER, LAST_NUMBER);
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executor = Executors.newFixedThreadPool(requests.size());
        List<CompletableFuture<Void>> results = new ArrayList<>();
        requests.forEach(squareRequest -> {
            results.add(CompletableFuture.runAsync(() -> squareRequest.longTimeSquare(resultConsumer), executor));
        });
        executor.shutdown();
        results.forEach(CompletableFuture::join);
        return resultConsumer.get();
    }

    public static void launch(long start, long finish) {
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        List<SquareRequest> requests = new ArrayList<>();
        for (long number = start; number <= finish; number++) {
            requests.add(new SquareRequest(number));
        }
        long result = fanOutFanIn(requests, resultConsumer);
        System.out.println("сумма квадратов чисел от " + start + " до " + finish + " равна " + result);
    }
}