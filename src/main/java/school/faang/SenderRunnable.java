package school.faang;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            log.info("Письмо отправлено {}" + i);
        }
    }

}
