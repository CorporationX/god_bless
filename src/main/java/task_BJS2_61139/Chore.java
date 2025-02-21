package task_BJS2_61139;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private static final long TASK_DURATION_MS = 1000;
    private final String name;

    @Override
    public void run() {
        try {
            System.out.printf("Задача \"%s\" - выполняется потоком \"%s\"\n", name, Thread.currentThread().getName());
            Thread.sleep(TASK_DURATION_MS);
            System.out.printf("Задача \"%s\" - выполнена потоком \"%s\"\n", name, Thread.currentThread().getName());
        } catch (InterruptedException exception) {
            System.out.printf("Задача \"%s\" - была прервана\n", name);
            Thread.currentThread().interrupt();
        }
    }
}
