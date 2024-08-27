package faang.school.godbless.BJS2_24457;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            players.add(new Player("Player" + i));
        }

        Boss molokosos = new Boss(3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (Player player : players) {
            executorService.submit(() -> {
                player.startBattle(molokosos);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                player.finishBattle(molokosos);
            });
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
                System.out.println("Время вышло. инициализируем shutdownNow.");
                List<Runnable> notExecutedTasks = executorService.shutdownNow();
                System.out.println("Количество не выполненых задач: " + notExecutedTasks.size());
            } else {
                System.out.println("Все задачи в пуле потоков выполенны");
            }
        } catch (InterruptedException e) {
            System.out.println("Ожидание завершения было прервано. Запускаем завершение работы прямо сейчас");
            List<Runnable> notExecutedTasks = executorService.shutdownNow();
            System.out.println("Количество не выполненых задач: " + notExecutedTasks.size());
            Thread.currentThread().interrupt();
        }
    }
}
