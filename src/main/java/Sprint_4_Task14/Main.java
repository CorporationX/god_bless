package Sprint_4_Task14;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        TelegramBot telegramBot = new TelegramBot(5, System.currentTimeMillis());
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> telegramBot.sendMessage("Inna super!"));
        }
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("Задание завершено");
    }
}
