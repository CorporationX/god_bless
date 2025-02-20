package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class MailSender {
    private static int TOTAL_MESSAGES = 1000;
    private static int THREADS_COUNT = 5;

    public static void main(String[] args) throws InterruptedException {
        int partMails = TOTAL_MESSAGES / THREADS_COUNT;
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);

        int start = 0;
        int end = 0;

        for (int i = 0; i < THREADS_COUNT; i++) {
            start = i * partMails;
            end = (i + 1) * partMails;
            executorService.submit(new SenderRunnable(start, end));
        }

        executorService.shutdown();
        log.info("Все письма успешно отправлены.");
    }

}
