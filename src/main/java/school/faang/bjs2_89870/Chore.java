package school.faang.bjs2_89870;

import lombok.AllArgsConstructor;

import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class Chore implements Runnable {
    private final String chore;

    @Override
    public void run() {
        System.out.printf("%s выполняет задачу %s.%n", Thread.currentThread().getName(), chore);

        try {
            int workTimeS = 2;
            TimeUnit.SECONDS.sleep(workTimeS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.printf("Поток %s прерван", Thread.currentThread().getName());
        }

        System.out.printf("%s закончил задачу %s.%n", Thread.currentThread().getName(), chore);
    }
}