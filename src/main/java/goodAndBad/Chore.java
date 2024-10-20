package goodAndBad;

import lombok.Value;

@Value
public class Chore implements Runnable {
    String chore;

    @Override
    public void run() {
        System.out.printf("Начало: %s - %s \n", Thread.currentThread().getName(), chore);

        try {
            Thread.sleep(3_00);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("Конец: %s - %s \n", Thread.currentThread().getName(), chore);
    }
}
