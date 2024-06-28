package faang.school.godbless.FanOutFanIn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class SquareRequest {
    private static final long MIN_TIMEOUT = 3000L;
    private final long number;

    public SquareRequest(long number) {
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


    public static long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executor = Executors.newFixedThreadPool(requests.size());
        List<CompletableFuture<Void>> futures = new ArrayList<>(requests.size());

        for (int i = 0; i < requests.size(); i++) {
            SquareRequest request = requests.get(i);
            CompletableFuture<Void> future = CompletableFuture.runAsync(() ->{
                request.longTimeSquare(resultConsumer);
            }, executor);
            futures.add(future);
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[requests.size()])).join();
        executor.shutdown();
        return resultConsumer.getResult();
    }

}