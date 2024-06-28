package faang.school.godbless.Task_FanOut_FanIn;

import java.util.concurrent.ThreadLocalRandom;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.CompletableFuture;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SquareRequest {
    private static final Long MIN_TIME = 3000L;
    private final Long number;

    public SquareRequest(Long number) {
        this.number = number;
    }

    public void longTimeSquare(ResultConsumer resultConsumer) {
        var randomTimeout = ThreadLocalRandom.current().nextInt(1000);
        try {
            Thread.sleep(MIN_TIME + randomTimeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            resultConsumer.add(number * number);
        }
    }

    public static void Launch() throws InterruptedException {
        List<SquareRequest> requests = new ArrayList<>();
        IntStream.rangeClosed(1, 1000).mapToLong(x -> (long) x).boxed()
                .forEach(x -> requests.add(new SquareRequest(x)));
        ResultConsumer zero = new ResultConsumer(0L);
        System.out.println("The calculation has been started! Wait a little bit");
        Long result = fanOutFanIn(requests, zero);
        System.out.println(result);
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer)
            throws InterruptedException {
        ExecutorService execution = Executors.newFixedThreadPool(requests.size());
        for (int i = 0; i < requests.size(); i++) {
            int index = i;
            CompletableFuture.runAsync(() -> {
                requests.get(index).longTimeSquare(resultConsumer);
            }, execution);
        }
        execution.shutdown();
        execution.awaitTermination(4, TimeUnit.SECONDS);
        System.out.print("The result is ");
        return resultConsumer.getValue();
    }
}