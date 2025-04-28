package school.faang.they_were_very_nice_but_extremely_poor;

import java.util.Random;

public record Chore(String chore) implements Runnable {
    private static final int MIN_DURATION = 1000;
    private static final int MAX_RANDOM = 4000;
    private static final Random random = new Random();

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Выполняю задачу: " + chore + " в потоке: " + threadName);
        try {
            int duration = random.nextInt(MAX_RANDOM) + MIN_DURATION;
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            System.err.println("Задача " + chore + " была прервана в потоке: " + threadName);
            Thread.currentThread().interrupt();
            return;
        }
        System.out.println("Задача " + chore + " выполнена в потоке: " + Thread.currentThread().getName());
    }
}