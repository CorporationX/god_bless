package school.faang.sprint3.bjs_48128;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        log.info("Emails from {} to {} have been sent", startIndex, endIndex);
    }
}
