package school.faang.bjs2_72743;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;
    private final int senderId;

    public SenderRunnable(int startIndex, int endIndex, int senderId) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.senderId = senderId;
    }

    @Override
    public void run() {
        for (int i = this.startIndex; i <= this.endIndex; i++) {
            log.info("email sender [{}] was sent email with index {}", senderId, i);
        }
    }
}
