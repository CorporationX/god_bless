package school.faang.task48208;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Chore implements Runnable {
    private static final int MAX_TIME = 30000;
    private static final int MIN_TIME = 10000;

    private final HouseholdChores chore;

    @Override
    public void run() {
        System.out.printf("%s выполняет: %s%n", Thread.currentThread().getName(), chore.getChore());

        try {
            Thread.sleep(new Random().nextInt(MAX_TIME - MIN_TIME + 1) + MIN_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("%s выполнено%n", chore.getChore());
    }
}
