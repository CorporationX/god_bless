package school.faang.spoty;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Music {
    public static void main(String[] args) throws InterruptedException {

        Player player = new Player();

        ExecutorService executor = Executors.newFixedThreadPool(5);

        executor.submit(() -> player.play());
        executor.submit(() -> player.pause());
        executor.submit(() -> player.skip());
        executor.submit(() -> player.previous());
        executor.submit(() -> player.play());

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("Final track: " + player.getCurrentTrack());
        System.out.println("Is playing: " + player.isPlaying());

    }
}
