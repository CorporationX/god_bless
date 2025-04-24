package school.faang.sprint3multythreading.microsoft;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class SenderRunnable implements Runnable {

    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex + 1; i <= endIndex; i++) {
            log.info("Письмо {} отправлено.", i);
        }
    }
}