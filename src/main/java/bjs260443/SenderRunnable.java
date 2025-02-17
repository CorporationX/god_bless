package bjs260443;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(SenderRunnable.class);
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        LOGGER.info("Thread {} started from {}", Thread.currentThread().getName(), this.startIndex);
        LOGGER.info("Письмо отправлено в потоке {}", Thread.currentThread().getName());
        LOGGER.info("Thread {} finished at {}", Thread.currentThread().getName(), this.endIndex);
    }
}
