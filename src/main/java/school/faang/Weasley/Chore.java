package school.faang.Weasley;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Chore implements Runnable {
    private final String title;
    private static final int TASK_DURATION_MS = 1000;

    @Override
    public void run() {
        try {
            System.out.printf("%s performs: %s%n", Thread.currentThread().getName(), title);
            Thread.sleep(1000);
            System.out.printf("%s completed!%n", title);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.printf("The task %s was interrupted%n", title);
            Thread.currentThread().interrupt();
        }
    }
}
