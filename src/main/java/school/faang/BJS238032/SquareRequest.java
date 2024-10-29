package school.faang.BJS238032;

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
        List<CompletableFuture<Void>> future = requests.stream()
                .map(request -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer)))
                .toList();
        CompletableFuture.allOf(future.toArray(new CompletableFuture[0])).join();
        return resultConsumer.getSum();
    }

    public static void launch() {
        long value = 1000;
        List<SquareRequest> squareRequests = new ArrayList<>();

        for (long i = 1; i < value; i++) {
            squareRequests.add(new SquareRequest(i));
        }

        ResultConsumer resultConsumer = new ResultConsumer(0L);
        fanOutFanIn(squareRequests, resultConsumer);
        System.out.println("Cумма квадратов чисел от 1 до 1000: " + resultConsumer.getSum());
    }
}
