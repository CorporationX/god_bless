package school.faang.task_49708;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(3);

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 5; i++) {
            final int playerNumber = i;
            executor.submit(() -> {
                Player player = new Player("Игрок " + playerNumber);
                player.startBattle(boss);
            });
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Не все игроки успели завершить сражение с боссом за отведенное время.");
            }
        } catch (InterruptedException e) {
            System.out.println("Главный поток был прерван.");
            Thread.currentThread().interrupt();
        }

        System.out.println("Сражение с боссом завершено!");
    }
}
