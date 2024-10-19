package school.faang.BJS2_36917;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(3);

        Player firstPlayer = new Player("John");
        Player secondPlayer = new Player("Stu");
        Player thirdPlayer = new Player("P.G.");
        Player fourthPlayer = new Player("Ada");

        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.submit(() -> {
            try {
                firstPlayer.startBattle(boss);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.submit(() -> {
            try {
                secondPlayer.startBattle(boss);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.submit(() -> {
            try {
                thirdPlayer.startBattle(boss);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.submit(() -> {
            try {
                fourthPlayer.startBattle(boss);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.shutdown();

        try {
            if (!executor.awaitTermination(15, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        if (executor.isShutdown()) {
            System.out.println("Сессия завершилась корректно");
        }
    }
}

