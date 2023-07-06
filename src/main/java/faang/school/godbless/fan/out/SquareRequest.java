package faang.school.godbless.fan.out;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Getter
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
        long result = 0;
        for (SquareRequest request : requests) {
            executor.execute(() -> request.longTimeSquare(resultConsumer));
            CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> resultConsumer.getSumOfSquaredNumbers().get());
            result = resultConsumer.getSumOfSquaredNumbers().get();
        }
        return result;
    }

    public static void launch() {
        List<SquareRequest> requests = new ArrayList<>();
        for (long i = 1; i < 10000; i++) {
            ResultConsumer resultConsumer = new ResultConsumer(i);
            requests.add(new SquareRequest(i));
            System.out.println(SquareRequest.fanOutFanIn(requests, resultConsumer));
        }
    }

    public static void main(String[] args) {
        launch();
    }

}
