package school.faang.bjs248720;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;
    private static final Logger LOGGER = LoggerFactory.getLogger(SenderRunnable.class);

    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            LOGGER.info("Письмо номер={} отправлено", i);
        }
    }
}
