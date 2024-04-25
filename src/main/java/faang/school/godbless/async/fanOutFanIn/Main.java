package faang.school.godbless.async.fanOutFanIn;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {

    public static void main(String[] args) {
        launch(1L, 5L);
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService threadPool = Executors.newCachedThreadPool();

        List<CompletableFuture<Void>> intermediateResults = new ArrayList<>();

        requests.forEach(request -> {
            Runnable squareCalculation = () -> request.longTimeSquare(resultConsumer);
            intermediateResults.add(CompletableFuture.runAsync(squareCalculation, threadPool));
        });

        threadPool.shutdown();


        intermediateResults.forEach(CompletableFuture::join);

        return resultConsumer.getSumOfSquaredNumbers();
    }

    public static void launch(Long startBase, Long endBase) {
        List<SquareRequest> requests = new ArrayList<>();

        for (long i = startBase; i <= endBase; i++) {
            requests.add(new SquareRequest(i));
        }

        Long squaresSum = fanOutFanIn(requests, new ResultConsumer(0L));

        log.info("The sum of squares [" + startBase + "; " + endBase + "] equals - " + squaresSum);
    }
}
