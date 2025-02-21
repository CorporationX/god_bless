package school.faang.task_61170;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private static final int TASK_DURATION_MS = 5000;
    private final String name;
    private final String task;

    @Override
    public void run() {
        System.out.printf("%s started on a task: %s\n", name, task);
        try {
            Thread.sleep(TASK_DURATION_MS);
        } catch (InterruptedException e) {
            System.out.printf("Task: %s was aborted\n", task);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        System.out.printf("%s completed the task: %s\n", name, task);
    }
}
