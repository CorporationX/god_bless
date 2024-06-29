package faang.school.godbless.sprint3.fanOutFanIn;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class SquareRequest {
    private static final int START_INITIAL_VALUE = 1;
    public static final int SIZE_OF_DELTA = 1;
    public static final long NEGATIVE_RESULT = -1;
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
        long result;

        List<CompletableFuture<Void>> completableFutures = requests.stream()
                .map(request -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer)))
                .toList();

        CompletableFuture<Void> all = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]));

        try {
            all.get();
            result = resultConsumer.get();
        } catch (InterruptedException | ExecutionException e) {
            result = NEGATIVE_RESULT;
        }

        return result;
    }

    public static List<SquareRequest> launch(int n) {
        AtomicLong count = new AtomicLong(START_INITIAL_VALUE);
        return Stream
                .generate(() -> new SquareRequest(count.addAndGet(SIZE_OF_DELTA)))
                .limit(n)
                .toList();
    }
}
