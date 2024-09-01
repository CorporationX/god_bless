package fan_out_fan_in;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        List<SquareRequest> requests = LongStream.rangeClosed(1, 1000)
                .mapToObj(SquareRequest::new)
                .toList();
        System.out.println(fanOutFanIn(requests, new ResultConsumer(0L)));
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(requests.size());
        requests.forEach(request -> {
            futures.add(CompletableFuture.runAsync(
                    () -> request.longTimeSquare(resultConsumer), executorService)
            );
        });
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        executorService.shutdown();
        return resultConsumer.getSumOfSquaredNumbers().get();
    }
}
