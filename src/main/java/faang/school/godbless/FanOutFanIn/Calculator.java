package faang.school.godbless.FanOutFanIn;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Slf4j
public class Calculator {
    private final static int THREAD_POOL_SIZE = 100;

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        List<CompletableFuture<Void>> futures = requests.stream()
                .map(request -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executorService))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(15, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException ex) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

        return resultConsumer.getSum();
    }

    public void launch() {
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        List<SquareRequest> requests = LongStream.rangeClosed(1, 1000)
                .mapToObj(SquareRequest::new)
                .collect(Collectors.toList());

        System.out.println(fanOutFanIn(requests, resultConsumer));
    }
}
