package school.faang.microsoft_bjs2_91125;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SenderRunnable implements Runnable {
    private final int startIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    private final int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            log.info("Письмо отправлено: " + i);
        }
    }
}