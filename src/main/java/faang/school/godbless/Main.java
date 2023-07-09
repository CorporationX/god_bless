package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static void main(String[] args) {
        List<SquareRequest> requests = createRequests(1, 100);
        ResultConsumer resultConsumer = new ResultConsumer(0L);

        AtomicLong result = fanOutFanIn(requests, resultConsumer);

        System.out.println("Сумма квадратов чисел от 1 до 1000: " + result);
    }


    public static AtomicLong fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        CompletableFuture<Void>[] futures = new CompletableFuture[requests.size()];

        for (int i = 0; i < requests.size(); i++) {
            SquareRequest request = requests.get(i);
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer));
            futures[i] = future;
        }

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures);
        try {
            allFutures.get();
            return resultConsumer.getSumOfSquaredNumbers();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private static List<SquareRequest> createRequests(int from, int to) {
        List<SquareRequest> requests = new ArrayList<>();
        for (int i = from; i <= to; i++) {
            requests.add(new SquareRequest((long) i));
        }
        return requests;
    }
}
