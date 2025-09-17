package school.faang.bsj2_91300;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private static final int SLEEP_PERIOD = 1000;

    private String chore;

    @Override
    public void run() {
        System.out.printf("Поток %s - задача %s\n", Thread.currentThread().getName(), chore);
        try {
            Thread.sleep(SLEEP_PERIOD);
        } catch (InterruptedException e) {
            System.out.printf("Не смог закончить задачу: %s", chore);
            Thread.currentThread().interrupt();
        }
    }
}
