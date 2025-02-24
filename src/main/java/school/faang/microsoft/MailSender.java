package school.faang.microsoft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MailSender {
    private static final int TOTAL_MESSAGES = 1000;
    private static final int THREADS_COUNT = 5;
    public static final Logger logger = LoggerFactory.getLogger(MailSender.class);

    public static void main(String[] args) {
        try {
            int batchSize = TOTAL_MESSAGES / THREADS_COUNT;
            int remainder = TOTAL_MESSAGES % THREADS_COUNT;
            Thread[] threads = new Thread[THREADS_COUNT];

            for (int i = 0; i < THREADS_COUNT; i++) {
                int start = i * batchSize;
                int end = start + batchSize + (i == THREADS_COUNT - 1 ? remainder : 0);
                threads[i] = new Thread(new SenderRunnable(start, end));
                threads[i].start();
            }

            for (Thread thread : threads) {
                thread.join();
            }

            logger.info("All emails have been sent!");
        } catch (InterruptedException e) {
            logger.error("Thread execution was interrupted", e);
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            logger.error("An unexpected error occurred", e);
        }
    }
}
