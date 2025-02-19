package school.faang.BJS2_60458;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MailSender {
    private static final Logger logger = LoggerFactory.getLogger(MailSender.class);

    private static final int THREAD_MESSAGE = 1000;
    private static final int THREAD_COUNT = 5;

    public static void main(String[] args) {
        int batchSize = THREAD_MESSAGE / THREAD_COUNT;
        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;

            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
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
