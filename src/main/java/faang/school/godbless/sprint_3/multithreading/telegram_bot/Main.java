package faang.school.godbless.sprint_3.multithreading.telegram_bot;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot(LocalDateTime.now());
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 4; i++) {
            executorService.submit(() -> bot.sendMessage("Hello"));
        }
        executorService.shutdown();
        System.out.println("Задача выполнена");
    }
}
