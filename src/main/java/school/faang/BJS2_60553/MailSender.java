package school.faang.BJS2_60553;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MailSender {
    private static final Logger logger = LoggerFactory.getLogger(MailSender.class);
    private static final int TOTAL_COUNT_MESSAGES = 1000;
    private static final int THREADS_COUNT = 5;
    private static final String DONE_MESSAGE = "All emails have been sent";
    private static final String THREAD_ERROR = "An execution error occurred in the thread: \n{}";

    public static void main(String[] args) throws InterruptedException {
        int batchSize = TOTAL_COUNT_MESSAGES / THREADS_COUNT;

        Thread[] threads = new Thread[THREADS_COUNT];

        for (int i = 0; i < THREADS_COUNT; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                logger.error(THREAD_ERROR, e.toString());
            }
        }
        logger.info(DONE_MESSAGE);
    }
}
