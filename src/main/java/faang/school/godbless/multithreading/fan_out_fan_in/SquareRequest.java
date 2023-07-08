package faang.school.godbless.multithreading.fan_out_fan_in;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.LongStream;

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

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executor = Executors.newFixedThreadPool(requests.size());
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (SquareRequest request : requests) {
            futures.add(CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executor));
        }
        executor.shutdown();
        CompletableFuture<Void> allFeatures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allFeatures.join();
        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    public static void launch() {
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        List<SquareRequest> requests = LongStream.rangeClosed(1, 1000).mapToObj(SquareRequest::new).toList();
        System.out.println(fanOutFanIn(requests, resultConsumer));
    }
}
