package school.faang.you_work_at_microsoft.BJS2_60544;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MailSender {
    private static final Logger log = LoggerFactory.getLogger(MailSender.class);

    private static final int TOTAL_MESSAGES = 1003;
    private static final int THREADS_COUNT = 5;

    public static void main(String[] args) {
        int batchSize = TOTAL_MESSAGES / THREADS_COUNT;
        int remainder = TOTAL_MESSAGES % THREADS_COUNT;
        Thread[] threads = new Thread[THREADS_COUNT];

        for (int i = 0; i < threads.length; i++) {
            int start = i * batchSize;
            int end = start + batchSize;

            if (i == threads.length - 1) {
                end += remainder;
            }

            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("Главный поток был прерван.{}", e.getMessage(), e);
                Thread.currentThread().interrupt();
                return;
            }
        }
        log.info("Все письма отправлены!");
    }
}
