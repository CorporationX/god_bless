package school.faang.microsoft;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.IntStream;

@RequiredArgsConstructor
public class SenderRunnable implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(SenderRunnable.class);
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        try {
            IntStream.range(startIndex, endIndex)
                    .forEach(i -> logger.info("The email has been sent {}", i));
        } catch (Exception e) {
            logger.error("Error occurred while sending emails", e);
        }
    }
}
