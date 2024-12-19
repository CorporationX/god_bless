package school.faang.sprint_3.task_bjs248550;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Chore implements Runnable {
    private static final int EMULATE_THREAD_WORK_MILLIS = 2000;
    private final String chore;

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        log.info("Thread {} is working on {}", threadName, chore);
        try {
            Thread.sleep(EMULATE_THREAD_WORK_MILLIS);
        } catch (InterruptedException e) {
            log.warn("Thread {} was interrupted", threadName);
            Thread.currentThread().interrupt();
        }
    }
}
