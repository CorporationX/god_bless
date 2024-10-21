package school.faang.telegrambot;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 20; i++) {
            int messageNumber = i + 1;
            executorService.submit(() -> bot.sendMessage("Hello from message #" + messageNumber));
        }

        executorService.shutdown();

        while (!executorService.isTerminated()) {
        }

        System.out.println("All tasks completed.");
    }
}

