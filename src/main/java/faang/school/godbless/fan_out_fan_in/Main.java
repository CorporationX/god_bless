package faang.school.godbless.fan_out_fan_in;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executorService = Executors.newFixedThreadPool(requests.size());
        List<CompletableFuture<Void>> futures = requests.stream()
                .map(r -> CompletableFuture.runAsync(() -> r.longTimeSquare(resultConsumer), executorService))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        executorService.shutdown();

        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    public static long launch(int bound) {
        List<SquareRequest> requests = new ArrayList<>();
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        for (int i = 1; i <= bound; i++) {
            requests.add(new SquareRequest((long) i));
        }
        return fanOutFanIn(requests, resultConsumer);
    }

    public static void main(String[] args) {
        System.out.println(launch(5));
    }
}
