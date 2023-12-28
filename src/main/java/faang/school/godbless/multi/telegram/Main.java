package faang.school.godbless.multi.telegram;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 53; i++) {
            int finalI = i;
            executorService.submit(() -> {
                try {
                    bot.sendMessage("Сообщение " + finalI);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Отправка прервана");
                }
            });
        }

        executorService.shutdown();
    }
}
