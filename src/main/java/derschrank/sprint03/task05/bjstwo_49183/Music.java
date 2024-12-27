package derschrank.sprint03.task05.bjstwo_49183;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Music {
    private static final int COUNT_OF_ITERATION = 1;
    private static final int SIZE_OF_THREADPOOL = 2;

    public static void main(String[] args) {

        PlayerInterface player = new Player();
        List<Runnable> commands = new ArrayList<>();
        commands.add(player::play);
        Runnable pause;
        commands.add(pause = player::pause);
        commands.add(player::skip);
        commands.add(player::previous);

        ExecutorService executor = Executors.newFixedThreadPool(SIZE_OF_THREADPOOL);
        for (int i = 0; i < COUNT_OF_ITERATION; i++) {
            for (Runnable cmd : commands) {
                executor.execute(cmd);
            }
        }

        executorShutdownAndAwait(executor);

        CompletableFuture<Void> future = CompletableFuture
                .runAsync(pause)
                .thenRun(() -> System.out.println("Music was ended"));
    }

    private static void executorShutdownAndAwait(ExecutorService executor) {
        try {
            executor.shutdownNow();
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.out.println("Music was interrupted: " + e);
        }
    }
}
