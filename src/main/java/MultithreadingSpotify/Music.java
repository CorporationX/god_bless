package MultithreadingSpotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Music {
    private static final int numberOfThreads = 4;
    public static void main(String[] args) {
        Player player = new Player();

        ExecutorService exec = Executors.newFixedThreadPool(numberOfThreads);
        exec.submit(() -> {
            player.play();
            player.skip();
            player.pause();
            player.previous();
        });
        exec.shutdown();
    }
}
