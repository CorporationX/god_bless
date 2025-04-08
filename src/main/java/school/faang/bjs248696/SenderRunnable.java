package school.faang.bjs248696;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex < 0 || startIndex > endIndex) {
            log.error("Invalid indices: startIndex={}, endIndex={}", startIndex, endIndex);
            throw new IllegalArgumentException("Invalid indices: startIndex=" + startIndex + ", endIndex=" + endIndex);
        }
        log.info("Initializing SenderRunnable with startIndex={} and endIndex={}", startIndex, endIndex);
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            log.info("Sending message {}", i);
        }
        log.info("Finished sending messages from {} to {}", startIndex, endIndex);

    }
}