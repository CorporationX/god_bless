package faang.school.godbless.BJS2_6037;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class SquareRequest {
    private static final long MIN_TIMEOUT = 3000L;
    private final Long number;

    public SquareRequest(Long number) {
        this.number = number;
    }

    public static void launch() {
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        List<SquareRequest> requests = new ArrayList<>();
        
        for (long i = 1; i <= 1000; i++) {
            requests.add(new SquareRequest(i));
        }

        System.out.println(fanOutFabIn(requests, resultConsumer));

    }

    public static Long fanOutFabIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        if (requests.isEmpty()) {
            throw new IllegalStateException();
        }

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (SquareRequest request : requests) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer));
            futures.add(future);
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        return resultConsumer.sumOfSquaredNumbers.get();
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
}
