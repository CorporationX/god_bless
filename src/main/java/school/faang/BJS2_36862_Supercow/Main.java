package school.faang.BJS2_36862_Supercow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(3);
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 10; i++) {
            Player player = new Player("Player " + i);
            executorService.submit(() -> player.startBattle(boss));
        }

        executorService.shutdown();
        try {
            if (executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                System.out.println("All battles have been finished successfully!");
            } else {
                System.out.println("All battles have been finished successfully! Shutting down executor service!");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            throw new IllegalStateException(
                    "Main thread was interrupted while waiting for battles to finish! Shutting down executor service!",
                    e
            );
        }
        boss.shutdownService();
    }
}
