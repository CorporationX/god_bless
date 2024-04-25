package faang.school.godbless.bjs2_5900;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {

    private static final int HIGH_NUMBER = 1000;
    private static final int NUM_THREADS = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        launch();
    }


    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        List<CompletableFuture<Void>> futureList = new ArrayList<>();
        for (SquareRequest request : requests) {
            CompletableFuture<Void> futureTask =
                    CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executorService);
            futureList.add(futureTask);
        }
        executorService.shutdown();
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0])).join();

        return resultConsumer.getSumOfSquareNumbers();
    }

    private static void launch() {
        ResultConsumer consumer = new ResultConsumer(0L);
        List<SquareRequest> requests = new ArrayList<>();

        for (long i = 1L; i <= HIGH_NUMBER; i++) {
            requests.add(new SquareRequest(i));
        }
        log.info("Result: {}", fanOutFanIn(requests, consumer));
    }
}
