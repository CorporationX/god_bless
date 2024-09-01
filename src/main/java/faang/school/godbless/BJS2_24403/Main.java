package faang.school.godbless.BJS2_24403;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int THREAD_POOL_SIZE = 10;
    private static final int MESSAGE_COUNT = 50;

    public static void main(String[] args) {
        TelegramBot telegramBot = new TelegramBot(0, System.currentTimeMillis());

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (int i = 0; i < MESSAGE_COUNT; i++) {
            final int finalI = i;
            executorService.execute(() -> telegramBot.sendMessage("Message " + finalI));
        }

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("All threads have finished");
            } else {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }

    }
}
