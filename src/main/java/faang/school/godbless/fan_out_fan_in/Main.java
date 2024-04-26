package faang.school.godbless.fan_out_fan_in;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;

@Slf4j
public class Main {
    private static final int THREAD_POOL_SIZE = 1000;

    public static void main(String[] args) {
        launch();
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        requests.forEach(request -> futures.add(CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executorService)));

        futures.forEach(CompletableFuture::join);
        executorService.shutdown();

        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    public static void launch() {
        List<SquareRequest> requests = new ArrayList<>();
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        LongStream.range(1, 1001).forEach(i -> requests.add(new SquareRequest(i)));
        log.info("Result: {}", fanOutFanIn(requests, resultConsumer));
    }
}