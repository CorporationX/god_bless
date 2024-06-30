package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class SquareCount {
    private static final Long NUMBER = 1000L;

    public static AtomicLong fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executor = Executors.newFixedThreadPool(requests.size());
        for (int i = 0;i< requests.size();i++) {
            int finalI = i;
            CompletableFuture.runAsync(() -> requests.get(finalI).longTimeSquare(resultConsumer), executor);
        }
        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return resultConsumer.getSumOfSquaredNumbers();
    }
    public static void main(String[] args) {
        List<SquareRequest> requests = new ArrayList<>();
        for (Long i =0L;i<NUMBER;i++) {
            requests.add(new SquareRequest(i));
        }
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        AtomicLong result = fanOutFanIn(requests,resultConsumer);
        System.out.println(result);
    }
}
