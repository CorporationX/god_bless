package faang.school.godbless.FanOutFanIn;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        launch();
    }

    public static void launch() throws ExecutionException, InterruptedException {
        List<SquareRequest> requests = IntStream.rangeClosed(1, 1000)
                .mapToObj(i -> new SquareRequest((long) i))
                .collect(Collectors.toList());
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        Long result = fanOutFanIn(requests, resultConsumer);
        System.out.println("Sum of squared numbers: " + result);
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) throws ExecutionException, InterruptedException {
        List<CompletableFuture<Void>> futures = requests.stream()
                .map(request -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer)))
                .collect(Collectors.toList());

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allOf.get();

        return resultConsumer.getSum();
    }
}