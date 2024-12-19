package school.faang.sprint_3.task_49565;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static final int THREADS_SIZE = 5;
    public static final int MESSAGE_COUNT = 5;
    public static final int TIMEOUT = 30;

    public static void main(String[] args) {
        TelegramBot telegramBot = new TelegramBot();

        ExecutorService executor = Executors.newFixedThreadPool(THREADS_SIZE);

        for (int i = 1; i <= MESSAGE_COUNT; i++) {
            String messageId = "Message#" + i;
            for (int j = 0; j < THREADS_SIZE; j++) {
                executor.submit(() -> telegramBot.sendMessage(messageId));
            }
        }
        executor.shutdown();
        try {
            executor.awaitTermination(TIMEOUT, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.info("Поток прерван при ожидании завершения задания");
        }
        System.out.println("Все задачи выполнены");
    }
}
