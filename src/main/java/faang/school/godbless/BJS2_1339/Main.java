package faang.school.godbless.BJS2_1339;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        lunch(0, 1000);
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executor = Executors.newFixedThreadPool(requests.size());

        List<CompletableFuture<Void>> completableFutures = requests.stream()
                .map(request -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executor))
                .toList();

        try {
            CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0])).join();
        } finally {
            executor.shutdown();
        }

        return resultConsumer.add(0L);
    }

    public static void lunch(int startInclusive, int endExclusive) {
        if (startInclusive >= endExclusive) {
            throw new IllegalArgumentException("endExclusive should be bigger then startInclusive");
        }

        List<SquareRequest> requests = new ArrayList<>();
        ResultConsumer resultConsumer = new ResultConsumer(0L);

        LongStream.range(startInclusive, endExclusive).forEach((i) -> requests.add(new SquareRequest(i)));

        System.out.println(fanOutFanIn(requests, resultConsumer));
    }
}