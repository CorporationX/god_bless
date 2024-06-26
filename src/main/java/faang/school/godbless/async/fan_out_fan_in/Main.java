package faang.school.godbless.async.fan_out_fan_in;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@Slf4j
public class Main {
    private static final Long NUMBER = 2000L;
    private static final Long START_VALUE = 0L;

    public static void main(String[] args) {
        log.info("Result: " + (fanOutFanIn(launch(NUMBER), new ResultConsumer(START_VALUE))));
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executor = Executors.newFixedThreadPool(requests.size());
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        requests.forEach(request ->
                futures.add(CompletableFuture.runAsync(() ->
                        request.longTimeSquare(resultConsumer), executor)));
        futures.forEach(CompletableFuture::join);
        executor.shutdown();
        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    private static List<SquareRequest> launch(long num) {
        List<SquareRequest> squareRequests = new ArrayList<>();
        LongStream.range(0, (num + 1)).boxed().forEach(number -> squareRequests.add(new SquareRequest(number)));
        return squareRequests;
    }
}
