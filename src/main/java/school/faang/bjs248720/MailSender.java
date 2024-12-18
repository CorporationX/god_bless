package school.faang.bjs248720;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MailSender {
    private static final int FULL_BATCH = 1000;
    private static final int BATCH = 200;
    private static final Logger LOGGER = LoggerFactory.getLogger(MailSender.class);

    public static void main(String[] args) {
        for (int i = 0; i < FULL_BATCH; i += BATCH) {
            Thread thread = new Thread(new SenderRunnable(i + 1, i + 200));
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                LOGGER.error("Thread = {} interrupted", thread.getName());
            }
        }
        LOGGER.info("All threads finished!");
    }
}
