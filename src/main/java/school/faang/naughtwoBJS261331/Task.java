package school.faang.naughtwoBJS261331;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private String performerName;
    private String task;

    @Override
    public void run() {
        try {
            System.out.printf("%s started the task '%s'%n", performerName, task);
            Thread.sleep(1000);
            System.out.printf("%s completed the '%s'%n", performerName, task);
        } catch (InterruptedException e) {
            System.out.printf("Task '%s' execution interrupted, performer - %s%n", task, performerName);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
