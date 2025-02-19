package school.faang.BJS2_60458;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    private static final Logger logger = LoggerFactory.getLogger(SenderRunnable.class);

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            logger.info("Письмо отправлено {}", i);
        }
    }
}
