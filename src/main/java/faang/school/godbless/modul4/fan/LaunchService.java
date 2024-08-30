package faang.school.godbless.modul4.fan;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;

@Slf4j
public class LaunchService {
    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        var executorService = Executors.newCachedThreadPool(Thread::new);

        CompletableFuture.allOf(
                requests.stream()
                        .map(request -> CompletableFuture.runAsync(
                                () -> request.longTimeSquare(resultConsumer),
                                executorService
                        ))
                        .toArray(CompletableFuture[]::new)
        ).join();

        executorService.shutdown();

        return resultConsumer.getLongSumOfSquaredNumbers();
    }

    public void launch(long startNum, long endNum) {
        var resultConsumer = new ResultConsumer(0L);

        var requests = LongStream.rangeClosed(startNum, endNum)
                .mapToObj(SquareRequest::new)
                .toList();

        log.info("Result: " + fanOutFanIn(requests, resultConsumer));
    }
}
