package microsoft;

import java.util.logging.Logger;

public class SenderRunnable implements Runnable {
    private static final Logger logger = Logger.getLogger(SenderRunnable.class.getName());
    private final int startIndex;
    private final int endIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex <= startIndex) {
            throw new IllegalArgumentException("Invalid index range: " + startIndex + " - " + endIndex);
        }
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        logger.info(threadName + " started sending emails!");
        for (int i = startIndex; i < endIndex; i++) {
            logger.info(threadName + ": The e-mail № " + (i + 1) + " has been sent.");
        }
        logger.info(threadName + " finished sending emails!");
    }
}