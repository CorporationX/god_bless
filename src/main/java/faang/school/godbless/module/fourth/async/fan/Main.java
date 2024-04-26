package faang.school.godbless.module.fourth.async.fan;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        launch(0, 1000);
    }
    
    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        requests.forEach((request) -> {
            futures.add(CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer)));
        });
        futures.forEach(CompletableFuture::join);
        return resultConsumer.getSumOfSquaredNumbers().get();
    }
    
    public static void launch(int rangeStart, int rangeEnd) {
        List<SquareRequest> requests = IntStream.range(rangeStart, rangeEnd + 1)
            .mapToObj((number) -> new SquareRequest((long) number))
            .collect(Collectors.toList());
        log.info("Result: {}", fanOutFanIn(requests, new ResultConsumer(0L)));
    }
}
