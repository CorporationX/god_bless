package Multithreading.bc2868;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        Boss boss = new Boss(2, 0);
        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            players.add(new Player("Player" + i));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(7);
        for (Player player : players) {
            executorService.execute(() -> {
                try {
                    player.startBattle(boss);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executorService.shutdown();
        if (executorService.awaitTermination(15, TimeUnit.SECONDS)) {
            System.out.println();
            System.out.println("Battles has been finished");
        }
    }
}
