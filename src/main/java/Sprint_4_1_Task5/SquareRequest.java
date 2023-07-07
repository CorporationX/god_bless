package Sprint_4_1_Task5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class SquareRequest {
    private static final long MIN_TIMEOUT = 3000L;
    private final Long number;

    public SquareRequest(Long number) {
        this.number = number;
    }

    public void longTimeSquare(ResultConsumer resultConsumer) {
        var randomTimeout = ThreadLocalRandom.current().nextInt(1000);
        try {
            Thread.sleep(MIN_TIMEOUT + randomTimeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            resultConsumer.add(number * number);
        }
    }
    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer){
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<CompletableFuture<Void>> completableFutures = requests.stream()
                .map(squareRequest ->
                        CompletableFuture.runAsync(() -> {
                            System.out.println(Thread.currentThread().getName() + " " + squareRequest.number);
                            squareRequest.longTimeSquare(resultConsumer);
                        }, executor))
                .toList();
        CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[completableFutures.size()])).join();
        executor.shutdown();
        return resultConsumer.getSumOfSquaredNumbers().get();
    }
    public static void launch(Long init){
        List<SquareRequest> requests = new ArrayList<>();
        for (long i = 1; i <= init; i++) {
            requests.add(new SquareRequest(i));
        }
        System.out.println(fanOutFanIn(requests, new ResultConsumer(0L)));
    }
    public static void main(String[] args) {
        launch(5L);
    }
}
