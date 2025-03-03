package school.faang.task_60808;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private static final int SLEEP_TIME_MS = 1000;
    private final String chore;


    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " выполняет задачу " + chore);
            Thread.sleep(SLEEP_TIME_MS);
            System.out.println(Thread.currentThread().getName() + " завершил задачу " + chore);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Задача была прервана: " + chore);
        }

    }
}
