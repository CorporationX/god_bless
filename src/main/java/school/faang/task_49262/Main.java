package school.faang.task_49262;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int MAX_LIVES = 10;

    public static void main(String[] args) {
        Game game = new Game(MAX_LIVES);
        ExecutorService executor = Executors.newCachedThreadPool();
        while (game.getLives() > 0) {
            executor.submit(game::update);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
