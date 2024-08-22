package faang.school.godbless.BJS2_24024;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Chore implements Runnable {
    private final String chore;
    private final Random random = new Random();

    @Override
    public void run() {
        System.out.printf("Thread: (%S) - Begin chore (%s)\n", Thread.currentThread().getName(), chore);
        try {
            Thread.sleep(getMilliseconds());
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread error");
        }
        System.out.printf("Thread: (%S) - End chore (%s)\n", Thread.currentThread().getName(), chore);
    }

    private int getMilliseconds() {
        return (random.nextInt(5) + 1) * 1000;
    }
}
