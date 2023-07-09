package faang.school.godbless.multithreading.broforce;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BroForce {
    private static final int NUM_THREADS = 4;

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_THREADS; i++) {
            service.execute(game::startGame);
        }
        service.shutdown();
        service.awaitTermination(10, TimeUnit.MINUTES);
        game.gameOver();
        System.out.println("Final score: " + game.getScore());
        System.out.println("Remaining lives: " + game.getLives());
    }
}

