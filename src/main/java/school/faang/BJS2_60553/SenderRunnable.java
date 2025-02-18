package school.faang.BJS2_60553;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(SenderRunnable.class);
    private static final String MESSAGE_SEND = "Email No. {} has been sent.";
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            logger.info(MESSAGE_SEND, i);
        }
    }
}
