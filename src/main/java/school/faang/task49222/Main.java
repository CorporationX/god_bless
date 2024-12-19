package school.faang.task49222;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot(0, System.currentTimeMillis());

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        executorService.scheduleAtFixedRate(() -> bot.sendMessage("Проверка"), 0, 1, TimeUnit.NANOSECONDS);

        try {
            TimeUnit.SECONDS.sleep(5);
            executorService.shutdown();
            if (executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                log.info("Выполнено");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Error message", e);
        }
    }
}
