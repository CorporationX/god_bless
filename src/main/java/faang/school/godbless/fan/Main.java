package faang.school.godbless.fan;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        System.out.println(launch());
        System.out.println(resultConsumer.getSumOfSquaredNumbers());
        fanOutFanIn(launch(), resultConsumer);
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executor = Executors.newFixedThreadPool(requests.size());

        for (SquareRequest request : requests) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                request.longTimeSquare(resultConsumer);
                System.out.println(resultConsumer.getSumOfSquaredNumbers());
            }, executor);

            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    public static List<SquareRequest> launch() {
        List<SquareRequest> list = new ArrayList<>();

        for (long i = 0; i < 1000; i++) {
            list.add(new SquareRequest(i + 1));
        }

        return list;
    }
}
