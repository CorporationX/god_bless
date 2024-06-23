package faang.school.godbless;

import java.util.Random;

public class Chore implements Runnable {
    private final String chore;

    public Chore(String chore) {
        this.chore = chore.toUpperCase();
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.printf("%s started %s.\n", threadName, chore);
        try {
            Thread.sleep(new Random().nextInt(10000) + 1000);
            System.out.printf("%s finished %s.\n", threadName, chore);
        } catch (InterruptedException e) {
            throw new RuntimeException(String.format("%s was interrupted on %s.\n", threadName, chore), e);
        }
    }
}
