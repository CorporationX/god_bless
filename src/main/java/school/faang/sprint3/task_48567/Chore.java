package school.faang.sprint3.task_48567;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private final String chore;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.printf("Выполняется: %s\n", chore);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s выполнен\n", chore);
    }
}
