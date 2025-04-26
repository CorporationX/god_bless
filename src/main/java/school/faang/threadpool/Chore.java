package school.faang.threadpool;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private static final int TASK_DURATION_MS = 3000;
    private final String chore;

    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " выполняет: " + chore);
            Thread.sleep(TASK_DURATION_MS);
            System.out.println(Thread.currentThread().getName() + " закончил: " + chore);
        } catch (InterruptedException e) {
            System.out.println("Задача была прервана: " + chore);
            Thread.currentThread().interrupt();
        }
    }
}
