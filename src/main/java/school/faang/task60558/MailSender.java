package school.faang.task60558;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MailSender {
    private static final Logger LOGGER = LoggerFactory.getLogger(MailSender.class);
    private static final String SUCCESS_SEND_MESSAGE = "Все письма были отправлены";
    private static final int THREAD_AMOUNT = 5;
    private static final int BATCH_SIZE = 200;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREAD_AMOUNT];

        for (int i = 0; i < THREAD_AMOUNT; i++) {
            int startIndex = i * BATCH_SIZE;
            int endIndex = (i + 1) * BATCH_SIZE;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        LOGGER.info(SUCCESS_SEND_MESSAGE);
    }
}
