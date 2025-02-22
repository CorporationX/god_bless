package school.faang.sprint.third.microsoft;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RequiredArgsConstructor
@Slf4j
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        validateIndexes();
        for (int i = startIndex; i <= endIndex; i++) {
            log.info("Current thread: {}. Sending {} email", Thread.currentThread().getId(), i);
        }
    }

    private void validateIndexes() {
        if (startIndex < 0 || endIndex < 0) {
            throw new IllegalArgumentException("Indexes cannot be negative");
        }
        if (startIndex > endIndex) {
            throw new IllegalArgumentException("End index cannot be less than start index");
        }
    }
}
