package school.faang.task_49286;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Runnable[] actions = {
                player::play,
                player::pause,
                player::skip,
                player::previous
        };

        ExecutorService executor = Executors.newFixedThreadPool(actions.length);

        for (int i = 0; i < actions.length; i++) {
            final int userIndex = i + 1;
            executor.submit(() -> {
                String threadName = "Пользователь " + userIndex;
                Thread.currentThread().setName(threadName);
                actions[userIndex - 1].run();
            });
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Не все действия пользователей завершились за отведенное время.");
            }
        } catch (InterruptedException e) {
            System.out.println("Главный поток был прерван.");
            Thread.currentThread().interrupt();
        }
    }
}
