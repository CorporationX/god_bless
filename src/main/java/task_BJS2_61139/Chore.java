package task_BJS2_61139;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private final String name;

    @Override
    public void run() {
        try {
            System.out.printf("Задача \"%s\" - выполняется потоком \"%s\"\n", name, Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.printf("Задача \"%s\" - выполнена потоком \"%s\"\n", name, Thread.currentThread().getName());
        } catch (InterruptedException exception) {
            System.out.printf("Задача \"%s\" - была прервана\n", name);
            Thread.currentThread().interrupt();
        }
    }
}
