package faang.school.godbless.asyncAndFuture.fanOutFanIn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        List<SquareRequest> requests = new ArrayList<>();
        launch(requests);
        Long result = fanOutFanIn(requests, new ResultConsumer(0L));
        System.out.println(result);
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executorService = Executors.newFixedThreadPool(requests.size());
        List<CompletableFuture<Void>> list = new ArrayList<>();

        requests.forEach((request) -> {
            list.add(CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executorService));
        });

        CompletableFuture.allOf(list.toArray(new CompletableFuture[0])).join();
        executorService.shutdown();

        return resultConsumer.get();
    }

    public static void launch(List<SquareRequest> requests) {
        requests.clear();
        LongStream.rangeClosed(1, 1000).boxed().forEach(number -> requests.add(new SquareRequest(number)));
    }
}
