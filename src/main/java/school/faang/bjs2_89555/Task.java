package school.faang.bjs2_89555;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;
    private static final int COUNT_SLEEP = 5000;

    @SneakyThrows
    public void run() {
        System.out.printf("Start task:%nEmployee: %s%nTask: %s%n", name, task);
        try {
            Thread.sleep(COUNT_SLEEP);
            System.out.println("Task " + task + " completed");
        } catch (InterruptedException e) {
            System.out.println("Task " + task + " was interrupted");
            Thread.currentThread().interrupt();
        }
    }
}
