package faang.school.godbless.sprint4.fan_out;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) {
        SquareRequest squareRequest = new SquareRequest(100L);
        SquareRequest squareRequest2 = new SquareRequest(100L);
        SquareRequest squareRequest3 = new SquareRequest(100L);
        List<SquareRequest> requests = List.of(squareRequest, squareRequest2, squareRequest3);

        fillList(new ResultConsumer(0L));

        AtomicLong result = fanOutFanIn(requests, new ResultConsumer(0L));
        System.out.println(result);
    }

    public static AtomicLong fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executorService = Executors.newFixedThreadPool(requests.size());
        CompletableFuture[] result = new CompletableFuture[requests.size()];
        for (int i = 0; i < requests.size(); i++) {
            int index = i;
            result[i] = CompletableFuture.runAsync(() -> requests.get(index).longTimeSquare(resultConsumer), executorService);
        }
        CompletableFuture<Void> allResult = CompletableFuture.allOf(result);

        try {
            allResult.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();

        return resultConsumer.sumOfSquaredNumbers;
    }

    public static void fillList(ResultConsumer resultConsumer) {
        for (long i = 0; i < 1000; i++) {
            resultConsumer.add(i);
        }
    }
}
