package faang.school.godbless.telegram_bot;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_NUM = 10;
    private static final long TIME_DELAY = 200L;
    private static final int TIME_LIMIT = 60;

    public static void main(String[] args) {
        TelegramBot telegramBot = new TelegramBot(0, LocalDateTime.now());

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUM);

        List<String> messages = getMessages();

        messages.forEach(message -> executorService.execute(() -> {
            try {
                Thread.sleep(Integer.parseInt(message) * TIME_DELAY);
                telegramBot.sendMessage("Сообщение " + message);
            } catch (InterruptedException e) {
                log.warn("Thread was interrupted: " + e.getMessage());
            }
        }));

        executorService.shutdown();

        try {
            executorService.awaitTermination(TIME_LIMIT, TimeUnit.SECONDS);
            log.info("Task was completed");
        } catch (InterruptedException e) {
            log.warn("Thread was interrupted");
        }
    }

    private static List<String> getMessages() {
        return List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    }
}
