package school.faang.task_49197;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();

        ExecutorService executor = Executors.newFixedThreadPool(30);

        for (int i = 0; i < 300; i++) {
            int finalI = i;
            executor.submit(() -> bot.sendMessage(finalI + " Hello World!"));
        }
    }
}
