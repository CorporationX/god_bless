package school.faang.task_60599;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MailSender {
    private static final int MAIL_COUNT = 1000;
    private static final int MAIL_PER_THREAD = 200;
    private static final int THREAD_COUNT = 5;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

        for (int i = 0; i < MAIL_COUNT; i += MAIL_PER_THREAD) {
            executorService.submit(new SenderRunnable(i, Math.min(i + MAIL_PER_THREAD, MAIL_COUNT)));
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

        log.info("\nУспех! Все письма успешно отправлены");
    }
}
