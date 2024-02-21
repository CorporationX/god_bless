package faang.school.godbless.multithreading_parallelism.they_were_very;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;
    private static final Random random = new Random();

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " выполняет задачу: " + chore);
        try {
            Thread.sleep(random.nextInt(12000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Готово " + chore);
    }
}
