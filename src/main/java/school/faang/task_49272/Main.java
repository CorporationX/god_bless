package school.faang.task_49272;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 100; i++) {
            executorService.submit(() -> {
                boolean earnedPoints = Math.random() > 0.5;
                boolean lostLife = Math.random() > 0.7;

                game.update(earnedPoints, lostLife);

                if (!game.update(earnedPoints, lostLife)) {
                    executorService.shutdown();
                    try {
                        if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                            System.err.println("Потоки не завершились вовремя");
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.err.println("Ошибка ожидания завершения потоков: " + e.getMessage());
                    }
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            });
        }
    }
}
