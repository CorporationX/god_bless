package school.faang.theywereverynicebutextremelypoor;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Getter
public class Chore implements Runnable {
    private static final Object PRINT_LOCK = new Object();

    private final String chore;

    @Override
    public void run() {
        synchronized (PRINT_LOCK) {
            System.out.printf("Task %s is executing...\n", chore);
            log.info(String.format("Thread %s is executing the task: %s.", Thread.currentThread().getName(), chore));
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread {} was interrupted during sleep!", Thread.currentThread().getName(), e);
        }
    }
}
