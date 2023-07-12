package faang.school.godbless.Sprint4Future.FanInFanOut;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SquareResult {
    private List<SquareRequest> requests = new ArrayList<>();
    private ResultConsumer resultConsumer = new ResultConsumer(0L);

    public static void main(String[] args) {
        SquareResult squareResult = new SquareResult();
        squareResult.launch();
        System.out.println(squareResult.resultConsumer.getSumOfSquaredNumbers());
    }
    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService service = Executors.newFixedThreadPool(requests.size());
        long startTime = System.currentTimeMillis();
        CompletableFuture.allOf(
                requests.stream()
                        .map(request -> CompletableFuture
                                .runAsync(() -> request.longTimeSquare(resultConsumer), service))
                        .toArray(CompletableFuture[]::new)).join();
        long endTime = (System.currentTimeMillis() - startTime) / 1000;
        System.out.println(endTime + " sec");
        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    public void launch() {
        for (long i = 1; i <= 1000; i++) {
            requests.add(new SquareRequest(i));
        }
        fanOutFanIn(requests, resultConsumer);
    }
}
