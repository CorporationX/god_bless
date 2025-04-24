package school.faang.bjs2_72903;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MailSender {
    private static final int THREADS_LIMIT = 5;
    private static final int MESSAGES_BATCH = 200;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_LIMIT);

        for (int i = 0; i < THREADS_LIMIT; i++) {
            executorService.execute(new SenderRunnable(i * MESSAGES_BATCH, (i + 1) * MESSAGES_BATCH - 1));
        }
        try {
            executorService.shutdown();
            if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
                log.error("Mails sending was not finished");
            }
            log.info("Mails sending was successfully finished");
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            log.error("Interrupted exception with message {} was thrown", e.getMessage());
        }
    }
}