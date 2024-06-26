package faang.school.godbless.BJS2_13560;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        launch();
    }

    // для каждого числа из requests создается поток, в котором resultConsumer добавляется квадрат этого чилса
    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService threadPool = Executors.newFixedThreadPool(requests.size());

        List<CompletableFuture<Void>> futures = requests.stream()
                        .map(squareRequestNum -> CompletableFuture.runAsync(() -> squareRequestNum.longTimeSquare(resultConsumer), threadPool))
                                .toList();

        // дожидаемся всех
        try {
            CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }  finally {
            threadPool.shutdown();
        }

        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    public static void launch() {
        List<SquareRequest> squareRequests = LongStream.rangeClosed(1, 1000)
                        .boxed()
                                .map(SquareRequest::new)
                                        .toList();

        System.out.println(fanOutFanIn(squareRequests, new ResultConsumer(0L)));
    }
}
