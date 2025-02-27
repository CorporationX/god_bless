package school.faang.bjs2_61772;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        Game game = new Game();
        ExecutorService pool = Executors.newFixedThreadPool(5);
        Random rand = new Random();

        while (!game.isGameOver()) {
            pool.submit(() -> {
                game.update(rand.nextBoolean(), rand.nextBoolean());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        pool.shutdownNow();
    }
}
