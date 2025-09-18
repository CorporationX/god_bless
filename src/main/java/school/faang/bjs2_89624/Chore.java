package school.faang.bjs2_89624;

import java.util.concurrent.TimeUnit;

public record Chore(String choreName) implements Runnable {
    private static final int OPERATION_TIME_IN_SECONDS = 5;

    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();
        System.out.printf("Поток Перси \"%s\" выполняет задачу \"%s\"\n", currentThreadName, choreName);
        try {
            TimeUnit.SECONDS.sleep(OPERATION_TIME_IN_SECONDS);
            System.out.printf("Отлично! Поток \"%s\" справился с задачей!\n", currentThreadName);
        } catch (InterruptedException e) {
            System.out.printf("Поток \"%s\" был прерван во время работы!\n", currentThreadName);
            Thread.currentThread().interrupt();
        }
    }
}
