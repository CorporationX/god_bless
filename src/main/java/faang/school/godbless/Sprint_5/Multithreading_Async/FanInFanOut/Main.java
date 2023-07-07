package faang.school.godbless.Sprint_5.Multithreading_Async.FanInFanOut;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static AtomicLong fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        List<CompletableFuture> cfs = new ArrayList<>();
        final int AMMOUNT_OF_THREADS = 5;
        ExecutorService executor = Executors.newFixedThreadPool(AMMOUNT_OF_THREADS);
        for (SquareRequest request : requests) {
            cfs.add(CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executor));
        }
        executor.shutdown();

        cfs.stream().forEach((cf) -> {
            try {
                cf.get(10, TimeUnit.MINUTES);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            } catch (TimeoutException e) {
                throw new RuntimeException("TIME OUT!");
            }
        });


        return resultConsumer.getSumOfSquaredNumbers();
    }

    public static void launch() {
        List<SquareRequest> requests = new ArrayList<>();
        for (long i = 1; i <= 1000; i++) {
            requests.add(new SquareRequest(i));
        }
        System.out.println(fanOutFanIn(requests, new ResultConsumer(new AtomicLong(0))).get());
    }

    public static void main(String[] args) {
        launch();
    }
}
