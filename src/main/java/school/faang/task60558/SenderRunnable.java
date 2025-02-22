package school.faang.task60558;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
@Getter
@Slf4j
public class SenderRunnable implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(SenderRunnable.class);
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            LOGGER.info("Письмо {} отправлено", i);
        }
    }
}
