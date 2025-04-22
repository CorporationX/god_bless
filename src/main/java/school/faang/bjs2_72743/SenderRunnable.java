package school.faang.bjs2_72743;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        for (int i = this.startIndex; i <= this.endIndex; i++) {
            log.info("email sender was sent email with index {}", i);
        }
    }
}
