package BJS2_60475;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            log.info("Отправка сообщения {}", i);
        }
    }
}
