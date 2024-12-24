package school.faang.sprint_3.task_49241;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUMBER_OF_PLAYERS = 10;
    private static final int AWAIT_DELAY = 1;

    public static void main(String[] args) {
        Game game = new Game();

        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_PLAYERS);

        for (int i = 1; i <= NUMBER_OF_PLAYERS; i++) {
            int finalI = i;
            executorService.submit(() -> {
                Player player = new Player("Player " + finalI);
                player.setLives(finalI);
                game.update(player, (finalI % 2 == 0));
            });
        }

        game.gameOver();
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(AWAIT_DELAY, TimeUnit.MINUTES)) {
                System.out.println("Await timed out. Shutting down...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted. Shutting down...");
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
