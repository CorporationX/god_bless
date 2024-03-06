package fan_out_fan_in;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        CompletableFuture<Void>[] futures = new CompletableFuture[requests.size()];

        for (int i = 0; i < requests.size(); i++) {
            SquareRequest request = requests.get(i);
            CompletableFuture<Void> future = CompletableFuture.runAsync(() ->
                    request.longTimeSquare(resultConsumer)
            );
            futures[i] = future;
        }

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures);

        try {
            allOf.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return resultConsumer.getSumOfSquaredNumbers();
    }

    public static void main(String[] args) {
        List<SquareRequest> requests = launch();
        ResultConsumer resultConsumer = new ResultConsumer(0L);

        System.out.println("Executing fanOutFanIn...");
        Long result = fanOutFanIn(requests, resultConsumer);
        System.out.println("fanOutFanIn completed!");

        System.out.println("Sum of squared numbers from 1 to 1000: " + result);
    }

    public static List<SquareRequest> launch() {
        List<SquareRequest> requests = new ArrayList<>();

        for (long i = 1; i <= 1000; i++) {
            requests.add(new SquareRequest(i));
        }

        return requests;
    }
}
