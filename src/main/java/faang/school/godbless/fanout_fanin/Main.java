package faang.school.godbless.fanout_fanin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        List<SquareRequest> squareRequests = new ArrayList<>();
    }

    public static void launch(List<SquareRequest> list) {
        for (long i = 1; i <= 1000; i++) {
            list.add(new SquareRequest(i));
        }
    }

    public static long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executorService = Executors.newFixedThreadPool(requests.size());

        List<CompletableFuture<Void>> futures = requests.stream()
                .map(request ->
                        CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executorService))
                .toList();
        executorService.shutdown();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        return resultConsumer.getSumOfSquaredNumbers().get();
    }
}
