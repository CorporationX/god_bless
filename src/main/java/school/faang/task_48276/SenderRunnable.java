package school.faang.task_48276;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            log.info("Email {} has been sent", i);
        }
    }
}
