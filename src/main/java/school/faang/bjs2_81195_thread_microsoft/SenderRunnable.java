package school.faang.bjs2_81195_thread_microsoft;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        log.info("Created sender thread. Start index {}, End index {}", startIndex, endIndex);
    }

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            log.info("Sending out letter at index {}", i);
        }
    }
}
