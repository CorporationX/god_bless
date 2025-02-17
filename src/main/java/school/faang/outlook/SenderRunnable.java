package school.faang.outlook;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
public class SenderRunnable implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(SenderRunnable.class);

    private final int startIndex;
    private final int finishIndex;

    @Override
    public void run() {
        logger.info("New thread {} has started working", Thread.currentThread().getName());
        for (int i = startIndex; i <= finishIndex; i++) {
            logger.info("Письмо {} отправлено!", i);
        }
    }
}
