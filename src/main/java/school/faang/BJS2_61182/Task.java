package school.faang.BJS2_61182;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private final String name;
    private final String task;

    @Override
    public void run() {
        try {
            System.out.printf("%s выполняет задачу %s\n", name, task);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.printf("Задача %s прервана!\n", task);
            System.err.printf("Error: %s\n", e.getMessage());
        }
    }
}
