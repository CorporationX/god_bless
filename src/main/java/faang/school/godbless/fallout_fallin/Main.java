package faang.school.godbless.fallout_fallin;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        List<SquareRequest> requests = LongStream.rangeClosed(1, 1000)
                .boxed()
                .map(SquareRequest::new)
                .toList();

        long result = fanOutFanIn(requests, new ResultConsumer(0L));

        System.out.println("Result = " + result);
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executorService = Executors.newFixedThreadPool(requests.size());

        Set<CompletableFuture<Void>> completableFutures = requests.stream()
                .map(request -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executorService))
                .collect(Collectors.toSet());

        completableFutures.forEach(CompletableFuture::join);
        executorService.shutdown();

        return resultConsumer.getSumOfSquaredNumbers().get();
    }
}
