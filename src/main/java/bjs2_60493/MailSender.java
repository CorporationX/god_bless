package bjs2_60493;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class MailSender {
    static final int CHUNK_COUNT = 5;
    static final int CHUNK_SIZE = 200;

    private static final Logger logger = LoggerFactory.getLogger(MailSender.class);

    public static void main(String[] args) {
        Thread[] threads = new Thread[CHUNK_COUNT];

        for (int i = 0; i < 5; i++) {
            int startIndex = CHUNK_SIZE * i;
            int endIndex = CHUNK_SIZE * (i + 1);

            SenderRunnable runner = new SenderRunnable(startIndex, endIndex);
            Thread thread = new Thread(runner);
            thread.start();

            threads[i] = thread;
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                logger.error("Ожидание завершения потока завершилось ошибкой: {}", e.getMessage());
            }
        }

        logger.debug("Все письма отправлены");
    }
}
