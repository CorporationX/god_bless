package school.faang.BJS2_60730;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class Chore implements Runnable {
    private static final int TASK_DURATION_MS = 1000;
    private String title;

    @Override
    public void run() {
        try {
            System.out.printf("%tT - %s выполняет задачу %s\n",
                    LocalDateTime.now(), Thread.currentThread().getName(), title);
            Thread.sleep(TASK_DURATION_MS);
            System.out.printf("%tT - %s выполнил задачу\n", LocalDateTime.now(), Thread.currentThread().getName());
        } catch (InterruptedException e) {
            System.err.printf("InterruptedException: %s\n", e.getMessage());
            Thread.currentThread().interrupt();
        }

    }
}
