package faang.school.godbless.FunOutFunIn;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;

@Slf4j
public class CountManager {
    private static final int UPPER_BOUND = 1000;
    private static final int NUM_THREADS = 1000;
    private static final ExecutorService EXECUTE = Executors.newFixedThreadPool(NUM_THREADS);

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        log.info("Start fanOutFanIn");
        List<CompletableFuture<Void>> completableFutureList = new ArrayList<>();
        log.info("Create completableFutureList");
        requests.forEach(request ->
                completableFutureList.add(CompletableFuture.runAsync(() ->
                        request.longTimeSquare(resultConsumer), EXECUTE)));
        completableFutureList.forEach(CompletableFuture::join);
        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    public void launch() {
        List<SquareRequest> squareRequestList = new ArrayList<>();
        log.info("Create squareRequestList");
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        log.info("Create resultConsumer");
        LongStream.range(1, UPPER_BOUND).forEach((number) -> squareRequestList.add(new SquareRequest(number)));
        log.info("Create " + UPPER_BOUND + " squareRequests");

        long result = CountManager.fanOutFanIn(squareRequestList, resultConsumer);
        System.out.println(result);
    }

    public static void shutdownManager() {
        EXECUTE.shutdown();
    }
}
