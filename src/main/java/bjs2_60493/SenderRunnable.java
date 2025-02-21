package bjs2_60493;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequiredArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    private static final Logger logger = LoggerFactory.getLogger(SenderRunnable.class);

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            logger.debug("Отправлено письмо #{}", i);
        }
    }
}
