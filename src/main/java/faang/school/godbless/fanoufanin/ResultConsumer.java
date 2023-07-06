import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
@Getter
public class ResultConsumer {
    private final AtomicLong sumOfSquaredNumbers;

    ResultConsumer(Long init) {
        sumOfSquaredNumbers = new AtomicLong(init);
    }

    public Long add(final Long num) {
        return sumOfSquaredNumbers.addAndGet(num);
    }
    public static long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer){
        ExecutorService executorService = Executors.newFixedThreadPool(requests.size());
        CompletableFuture[] futures = new CompletableFuture[requests.size()];
        int i=0;
        for (SquareRequest request : requests) {
            futures[i] = CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executorService);
            i++;
        }
        executorService.shutdown();
        CompletableFuture.allOf(futures).join();
        return resultConsumer.sumOfSquaredNumbers.get();
    }
    public static void launch(Long n){
        List<SquareRequest> requests = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            requests.add(new SquareRequest((long) i));
        }
        System.out.println(fanOutFanIn(requests, new ResultConsumer(0L)));
    }

    public static void main(String[] args) {
        launch(1000L);
    }
}