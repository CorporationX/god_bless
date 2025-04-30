package school.faang.fan_calculations;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.LongStream;

@Slf4j
public class Main {
    private static final ResultConsumer resultConsumer = new ResultConsumer(0L);

    public static void main(String[] args) {
        launch();
    }

    private static void launch() {
        List<SquareRequest> squareRequests = LongStream.range(0, 1000).mapToObj(SquareRequest::new).toList();
        Long result = fanOutFanIn(squareRequests, resultConsumer);
        ThreadPoolProvider.gracefullyShutdown();
        log.info("Result: " + result);
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        List<CompletableFuture<Void>> list = requests.stream()
                .map(request -> CompletableFuture.runAsync(() ->
                {
                    try {
                        request.longTimeSquare(resultConsumer);
                    } catch (Throwable e) {
                        log.warn("Ошибка в задаче", e);
                    }
                }, ThreadPoolProvider.executor))
                .toList();
        CompletableFuture.allOf(list.toArray(new CompletableFuture[0])).join();
        return resultConsumer.getSum();
    }

}
