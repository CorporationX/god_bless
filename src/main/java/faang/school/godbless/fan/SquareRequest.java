package faang.school.godbless.fan;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

public class SquareRequest {
    private static final long MIN_TIMEOUT = 3000L;
    private final Long number;
    private final static int MAX_QUANTITY = 1000;
    public SquareRequest(Long number) {
        this.number = number;
    }

    public static void main(String[] args) {
        SquareRequest.launch();
    }

    @SuppressWarnings("CallToPrintStackTrace")
// идея подсказала, не знаю, для чего это. Прост перестал Trace подчеркиваться
    public void longTimeSquare(ResultConsumer resultConsumer) {
        int randomTimeout = ThreadLocalRandom.current().nextInt(1000);
        try {
            Thread.sleep(MIN_TIMEOUT + randomTimeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            resultConsumer.add(number * number);
        }
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executorService = Executors.newFixedThreadPool(requests.size());
        var futures = requests.stream()
                .map(request -> CompletableFuture.runAsync(() -> {
                    request.longTimeSquare(resultConsumer);
                }, executorService))
                .toArray(CompletableFuture[]::new);
        executorService.shutdown();
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures);
        try {
            allOf.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        AtomicLong result = resultConsumer.getSumOfSquaredNumbers();
        return result.get();
    }

    public static void launch() {
        List<SquareRequest> requests = new ArrayList<>();
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        for (long i = 1; i <= MAX_QUANTITY; i++) {
            requests.add(new SquareRequest(i));
        }
        Long result = fanOutFanIn(requests, resultConsumer);
        System.out.println(result);
    }
}
