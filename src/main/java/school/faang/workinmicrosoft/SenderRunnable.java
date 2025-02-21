package school.faang.workinmicrosoft;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private static final Integer MILLISECONDS = 10;
    private final Integer startIndex;
    private final Integer endIndex;

    /**
     * Метод отправки сообщений.
     * Так же метод имеет симуляцию задержки отправки сообщений
     */
    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            try {
                log.info("letter {} is send \n", i);
                Thread.sleep(MILLISECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.info("Thread interrupted");
            }
        }
    }
}
