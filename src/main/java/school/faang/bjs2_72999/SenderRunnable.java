package school.faang.bjs2_72999;

import lombok.extern.slf4j.Slf4j;
import lombok.AllArgsConstructor;

@Slf4j
@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            log.info("Message {} has been sent.", i);
        }
    }
}
