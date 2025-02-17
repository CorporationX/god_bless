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
            try {
                Thread.sleep(100);
                log.info("Email {} has been sent a {}", index + 1, Thread.currentThread().getName());
            } catch (InterruptedException exception) {
                log.error("Thread interrupted. {}\n{}", exception, Thread.currentThread().getName());
                Thread.currentThread().interrupt();
            }
        }
    }
}
