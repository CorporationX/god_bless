package derschrank.sprint03.task05.bjstwo_49183;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Music {
    private static final int COUNT_OF_ITERATION = 10;

    public static void main(String[] args) {
        PlayerInterface player = new Player();
        Runnable play = () -> player.play();
        Runnable pause = () -> player.pause();
        Runnable skip = () -> player.skip();
        Runnable previous = () -> player.previous();

        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < COUNT_OF_ITERATION; i++) {
            executor.execute(play);
            executor.execute(pause);
            executor.execute(skip);
            executor.execute(previous);
        }

        try {
            executor.shutdownNow();
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.out.println("Music was interrupted: " + e);
        }

        CompletableFuture<Void> future = CompletableFuture
                .runAsync(pause)
                .thenRun(() -> System.out.println("Music was ended"));
    }
}
