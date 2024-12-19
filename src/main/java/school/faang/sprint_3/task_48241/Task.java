package school.faang.sprint_3.task_48241;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Task implements Runnable {
    private static final int TASK_DURATION = 10000;

    private final String executorName;
    private final String taskName;

    @Override
    public void run() {
        try {
            System.out.printf("%s starts %s\n", executorName, taskName);
            Thread.sleep(TASK_DURATION);
            System.out.printf("%s ends %s\n", executorName, taskName);
        } catch (InterruptedException e) {
            System.out.printf("%s was interrupted\n", taskName);
        }
    }
}
