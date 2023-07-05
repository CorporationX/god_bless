package faang.school.godbless.spring_4.fan_out_fan_in;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    private static final ExecutorService POOL = Executors.newFixedThreadPool(1000);

    public static void main(String[] args) {

        ResultConsumer resultConsumer = new ResultConsumer(0L);

        List<SquareRequest> requests = new ArrayList<>();


        launch(requests, resultConsumer);

    }

    private static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {

        List<Future<Void>> futures = new ArrayList<>();

        for (SquareRequest request : requests) {
            futures.add(CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), POOL));
        }

        POOL.shutdown();

        futures.forEach(voidFuture -> {
            try {
                voidFuture.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    private static void launch(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        for (int i = 0; i < 1000; i++) {
            requests.add(new SquareRequest((long) i));
        }

        long result = fanOutFanIn(requests, resultConsumer);
        System.out.println(result);
    }
}
