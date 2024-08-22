package faang.school.godbless.nice.and.poor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
public class Chore implements Runnable {
    private static final int TASK_TIME_IN_SECONDS = 3;
    private final String taskName;

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        try {
            System.out.printf("%s started task %s\n", threadName, taskName);
            TimeUnit.SECONDS.sleep(TASK_TIME_IN_SECONDS);
            System.out.printf("%s ended task %s\n", threadName, taskName);
        } catch (InterruptedException exception) {
            log.error(String.format("%s was interrupted while it did his task \"%s\"", threadName, taskName), exception);
            Thread.currentThread().interrupt();
        }
    }
}
