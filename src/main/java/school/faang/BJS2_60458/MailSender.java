package school.faang.BJS2_60458;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MailSender {
    private static final Logger logger = LoggerFactory.getLogger(MailSender.class);

    private static final int THREAD_MESSAGE = 1003;
    private static final int THREAD_COUNT = 5;

    public static void main(String[] args) {
        int batchSize = THREAD_MESSAGE / THREAD_COUNT;
        int remainder = THREAD_MESSAGE % THREAD_COUNT;

        Thread[] threads = new Thread[THREAD_COUNT];

        int start = 1;
        for (int i = 0; i < THREAD_COUNT; i++) {
            int end = start + batchSize;

            if (i == THREAD_COUNT - 1) {
                end += remainder;
            }

            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
            start = end;
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                logger.error("Главный поток был прерван во время ожидания завершения работы потоков", e);
                Thread.currentThread().interrupt();
            }
        }

        logger.info("Все письма отправлены!");
    }
}
