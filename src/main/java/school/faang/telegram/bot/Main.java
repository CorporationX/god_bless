package school.faang.telegram.bot;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            String message = "message" + i;
            executorService.submit(() -> bot.sendMessage(message));
        }
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Задача выполнена!");
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            log.error(Arrays.toString(e.getStackTrace()));
        }
    }
}
