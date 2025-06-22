package school.faang.module1.bjs2_81819;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int POOL_SIZE = 10;
    private static final int TOTAL_MESSAGES = 20;
    private static final int TIMEOUT = 10;

    public static void main(String[] args) {
        TelegramBot telegramBot = new TelegramBot();
        ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);
        for (int i = 0; i < TOTAL_MESSAGES; i++) {
            int number = i;
            executorService.execute(() -> telegramBot.sendMessage("Сообщение-" + number));
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                log.info("Некоторые задачи не успели завершиться вовремя");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Главный поток был прерван");
            executorService.shutdownNow();
        }
        log.info("Все сообщения были отправлены");
    }
}