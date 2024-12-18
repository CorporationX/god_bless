package school.faang.task_49197;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();

        ExecutorService executor = Executors.newFixedThreadPool(30);

        for (int i = 0; i < 300; i++) {
            int finalI = i;
            executor.submit(() -> bot.sendMessage(finalI + " Hello World!"));
        }

        try {
            if (executor.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Все сообщения отправлены");
            } else {
                executor.shutdownNow();
                System.out.println("Задачи не успеши завершиться вовремя");
            }
        } catch (InterruptedException e) {
            System.out.println("Ошибка выполнения задач: " + e);
        }
    }
}
