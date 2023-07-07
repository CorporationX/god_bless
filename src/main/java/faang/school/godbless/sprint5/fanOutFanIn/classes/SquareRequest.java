package faang.school.godbless.sprint5.fanOutFanIn.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

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
        ExecutorService threadPool = Executors.newFixedThreadPool(requests.size());
        for (SquareRequest request : requests) {
            CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), threadPool);
        }
        threadPool.shutdown();
        try {
            threadPool.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return resultConsumer.add(0L);
    }

    public void launch() {
        List<SquareRequest> list = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            list.add(new SquareRequest((long) i));
        }
        long result = fanOutFanIn(list, new ResultConsumer(0L));
        System.out.println(result);
    }
}
