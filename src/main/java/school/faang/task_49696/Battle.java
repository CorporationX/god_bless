package school.faang.task_49696;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Battle {
    public static void main(String[] args) {
        Boss boss = new Boss(2);

        Player player = new Player("player1");
        Player player2 = new Player("player2");
        Player player3 = new Player("player3");

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(() -> player.startBattle(boss));
        executorService.submit(() -> player2.startBattle(boss));
        executorService.submit(() -> player3.startBattle(boss));

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(8, TimeUnit.SECONDS)) {
                System.out.println("shutting down..");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("end of game");
    }
}