package faang.school.godbless.sprint_3.multithreading_future.fan_out_fan_in;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        launch();
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService service = Executors.newFixedThreadPool(requests.size());
        CompletableFuture<?>[] completableFutures = new CompletableFuture[requests.size()];
        for (int i = 0; i < requests.size(); i++) {
            SquareRequest request = requests.get(i);
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), service);
            completableFutures[i] = future;
        }
        CompletableFuture.allOf(completableFutures).join();
        service.shutdown();
        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    public static void launch() {
        List<SquareRequest> requests = new ArrayList<>(1000);
        for (long i = 0; i < 1000; i++) {
            SquareRequest request = new SquareRequest(i);
            requests.add(request);
        }
        Long result = fanOutFanIn(requests, new ResultConsumer(0L));
        System.out.println(result);
    }
}