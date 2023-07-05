package faang.school.godbless.Sprint4.Task_14_TelegramBot;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();
        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 40; i++) {
            String message = "Message " + i;
            executor.execute(() -> {
                bot.sendMessage(message);
            });
        }
        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Задача выполнена!");
    }
}


