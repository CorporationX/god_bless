package school.faang.workatmicrosoft;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int index = startIndex; index < endIndex; index++) {
            log.info("Email {} has been sent", index + 1);
        }
    }
}
