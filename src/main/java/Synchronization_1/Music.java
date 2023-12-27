package Synchronization_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Music {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Player player = new Player();
        for (int i = 0; i < 5; i++) {
            executor.submit(() -> player.play());
            executor.submit(() -> player.pause());
            executor.submit(() -> player.skip());
            executor.submit(() -> player.previous());
        }
        executor.shutdown();
    }
}
