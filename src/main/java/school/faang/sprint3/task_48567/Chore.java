package school.faang.sprint3.task_48567;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private final String chore;
    private static final int THREAD_SLEEP_TIME = 5000;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.printf("Выполняется: %s\n", chore);

        try {
            Thread.sleep(THREAD_SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s выполнен\n", chore);
    }
}
