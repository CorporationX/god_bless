package faang.school.godbless.FanOut_FanIn;

import lombok.ToString;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

@ToString
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
            System.out.println();
        } finally {
            resultConsumer.add(number * number);
        }
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < requests.size(); i++) {
            int finalI = i;
            var voidCompletableFuture = CompletableFuture.runAsync(() ->
                    requests.get(finalI).longTimeSquare(resultConsumer), executor);
            voidCompletableFuture.join();
        }
        executor.shutdown();
        return resultConsumer.getSumOfSquaredNumbers().get();
    }
}
