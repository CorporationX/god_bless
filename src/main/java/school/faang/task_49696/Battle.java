package school.faang.task_49696;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Battle {
    private static final int TIMEOUT = 8;

    public static void main(String[] args) {
        Boss boss = new Boss(2);

        final List<Player> players = Arrays.asList(
                new Player("player1"),
                new Player("player2"),
                new Player("player3"),
                new Player("player4"),
                new Player("player5")
        );

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        players.forEach(player -> executorService.submit(() -> player.startBattle(boss)));

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                System.out.println("shutting down..");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("end of game");
    }
}