package faang.school.godbless.parallelism.microsoft;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int id = startIndex; id <= endIndex; id++) {
            log.info("Mail with id = " + id + " was processed successfully.");
        }
    }
}
