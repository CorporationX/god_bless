package faang.school.godbless.microsoft.outlook;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MailSender {
    private static final int THREADS_COUNT = 5;
    private static final int MESSAGES_COUNT = 1000;
    private static final int MESSAGES_BATCH = MESSAGES_COUNT / THREADS_COUNT;
    private static final String SUCCESS = ">>> Mails sent successful";
    private static final String FAIL = ">>> Some tasks failed to complete within the specified timeout";
    private static final int TIMEOUT = 10_000;


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);
        for (int i = 0; i < THREADS_COUNT; i++) {
            SenderRunnable senderRunnable = new SenderRunnable();
            senderRunnable.setStartIndex(MESSAGES_BATCH * i + 1);
            senderRunnable.setEndIndex(MESSAGES_BATCH * (i + 1));

            executorService.submit(senderRunnable);
        }
        executorService.shutdown();

        if (executorService.awaitTermination(TIMEOUT, TimeUnit.MILLISECONDS)) {
            log.info(SUCCESS);
        } else {
            log.error(Thread.currentThread().getName() + FAIL);
            throw new InterruptedException(FAIL);
        }
    }
}
