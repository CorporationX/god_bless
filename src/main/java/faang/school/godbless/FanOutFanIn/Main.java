package faang.school.godbless.FanOutFanIn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executor = Executors.newFixedThreadPool(requests.size());
        List<CompletableFuture<Void>> futures =
                requests.stream()
                        .map(request -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executor))
                        .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        executor.shutdown();
        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    public static long launch(List<SquareRequest> squareRequest) {
        ResultConsumer result = new ResultConsumer(0L);
        int rnd = (int) (Math.random() * 10);
        System.out.println("Возводим в квадрат числа от 1 до " + rnd);
        for (long i = 1; i <= rnd; i++) {
            squareRequest.add(new SquareRequest(i));
        }
        return fanOutFanIn(squareRequest, result);
    }

    public static void main(String[] args) {
        List<SquareRequest> squareRequestList = new ArrayList<>();
        System.out.println("Сумма квадратов: " + launch(squareRequestList));
    }
}
