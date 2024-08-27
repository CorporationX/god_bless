package faang.school.godbless.squares;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private final static int NUM_COUNT = 1000;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        launch();
    }

    private static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(1000);
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < NUM_COUNT; i++) {
            int finalI = i;
            futures.add(CompletableFuture.runAsync(
                    () -> requests.get(finalI).longTimeSquare(resultConsumer)
                    , service));
        }

        futures.stream()
                .forEach(f -> {
                    try {
                        f.get();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                });//дожидается выполнения всех задач

        service.shutdown();

        return resultConsumer.add(0L);
    }

    private static void launch() throws ExecutionException, InterruptedException {
        List<SquareRequest> requests = new ArrayList<>();
        for (int i = 1; i <= NUM_COUNT; i++) {
            requests.add(new SquareRequest((long) i));
        }
        ResultConsumer consumer = new ResultConsumer(0L);
        System.out.println(fanOutFanIn(requests, consumer));
    }
}
