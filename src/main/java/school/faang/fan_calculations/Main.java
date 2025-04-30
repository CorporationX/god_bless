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
        log.info("Result: " + result);
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        List<Void> list = requests.stream().map(request -> CompletableFuture.runAsync(() -> {
            request.longTimeSquare(resultConsumer);
        })).map(CompletableFuture::join).toList();
        return resultConsumer.getSum();
    }

}
