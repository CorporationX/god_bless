package school.faang.task_49206;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        TelegramBot telegramBot = new TelegramBot();
        ExecutorService executorService = Executors.newFixedThreadPool(25);

        for (int i = 0; i < 25; i++) {
            int finalI = i;
            executorService.execute(() -> {
                try {
                    telegramBot.sendMessage("message number : " + finalI);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}