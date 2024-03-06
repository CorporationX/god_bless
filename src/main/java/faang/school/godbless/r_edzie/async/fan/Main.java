package faang.school.godbless.r_edzie.async.fan;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        List<SquareRequest> requestList = new ArrayList<>();

        for (long i = 0; i < 100; i++) {
            requestList.add(new SquareRequest(i));
        }

        System.out.println(fanOutFanIn(requestList, new ResultConsumer(0L)));
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executorService = Executors.newFixedThreadPool(requests.size());

        List<CompletableFuture<Void>> futureResult = requests
                .stream()
                .map(request -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executorService))
                .toList();

        CompletableFuture.allOf(futureResult.toArray(new CompletableFuture[0])).join();

        executorService.shutdown();

        return resultConsumer.getSumOfSquaredNumbers().longValue();
    }
}
