package school.faang.naughtwoBJS260577;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            log.info("letter {} sent%n", i);
        }
    }
}
