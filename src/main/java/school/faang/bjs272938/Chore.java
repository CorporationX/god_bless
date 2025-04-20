package school.faang.bjs272938;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Chore implements Runnable {
    private String title;

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.printf("Current thread: %s\n", threadName);
        System.out.printf("Started: %s\n", title);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("Thread {} interrupted: {}", threadName, e.getMessage());
        }

        System.out.printf("Chore \"%s\" is done!\n", title);
    }
}
