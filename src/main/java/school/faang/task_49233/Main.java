package school.faang.task_49233;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) {
        TelegramBot telegramBot = new TelegramBot();
        ExecutorService executorService = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);

        for (int i = 0; i < 20; i++) {
            int numberMessage = i;
            executorService.submit(() -> telegramBot.sendMessage("Сообщение № " + numberMessage));
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            log.info("Принудительное завершение при прерывании" + e.getMessage());

        }

        System.out.println("Все сообщения отправлены.");

    }
}
