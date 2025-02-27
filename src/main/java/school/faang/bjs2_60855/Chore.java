package school.faang.bjs2_60855;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {

    private static final int TASK_DURATION_MS = 1000;

    private String title;

    @Override
    public void run() {
        System.out.printf("Задача: \"%s\" выполняется в потоке %s%n", title, Thread.currentThread().getName());
        try {
            Thread.sleep(TASK_DURATION_MS);
            System.out.printf("Задача: \"%s\" - выполнена!%n", title);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
