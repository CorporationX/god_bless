package school.faang.bjs2_89556;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private static final long TIME_SEND_LETTER = 10;
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            try {
                Thread.sleep(TIME_SEND_LETTER);
                log.info("letter {} sent", i);
            } catch (InterruptedException e) {
                log.error("Error", e);
            }
        }
    }
}
