package faang.school.godbless.pi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int NUMBER_THREAD = 5;
    private static ExecutorService executor = Executors.newFixedThreadPool(NUMBER_THREAD);

    public static void main(String[] args) {
        ServicePI pi = new ServicePI();
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < 3000000; i++) {
            futures.add(CompletableFuture.runAsync(pi::studyGettingPointIntoCircle, executor));
        }
        //не дожидается выполнения потока
        CompletableFuture<Void> resultFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));
        resultFuture.thenAccept(v ->
                futures.stream().
                        map(future -> future.join())
        ).join();
        executor.shutdown();
        System.out.println((double) 4 * pi.getInside() / pi.getAll());
    }
}
