package school.faang.microsoft;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.logging.Level;
import java.util.logging.Logger;

@AllArgsConstructor
@Getter
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;
    private static final Logger LOGGER = Logger.getLogger(SenderRunnable.class.getName());

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            LOGGER.setLevel(Level.INFO);
            LOGGER.info("The message was sent. Message number - " + i);
        }
    }
}
