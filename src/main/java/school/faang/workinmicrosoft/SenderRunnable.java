package school.faang.workinmicrosoft;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequiredArgsConstructor
public class SenderRunnable implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(SenderRunnable.class);
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            logger.info("Письмо отправлено: " + i);
        }
    }
}