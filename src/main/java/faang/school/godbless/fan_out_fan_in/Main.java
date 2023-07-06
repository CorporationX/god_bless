package faang.school.godbless.fan_out_fan_in;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static List<SquareRequest> launch() {
        List<SquareRequest> requests = new ArrayList<>();
        for(int i = 1; i <= 100; i++) {
            requests.add(new SquareRequest((long)i));
        }
        return requests;
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executorService = Executors.newFixedThreadPool(requests.size());

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for(SquareRequest request : requests) {
            CompletableFuture<Void> calc = CompletableFuture.runAsync(() -> {
                request.longTimeSquare(resultConsumer);
            }, executorService);
            futures.add(calc);
        }

        futures.forEach(CompletableFuture :: join);

        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    public static void main(String[] args) {
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        List<SquareRequest> requests = launch();
        System.out.println(fanOutFanIn(requests, resultConsumer));
    }
}
