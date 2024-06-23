package faang.school.godbless;

import java.util.Random;

public class Chore implements Runnable {
    private final String chore;
    private final static int maxSleepTimeout = 10000;
    private final static int minSleepTimeout = 1000;

    public Chore(String chore) {
        this.chore = chore.toUpperCase();
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.printf("%s started %s.\n", threadName, chore);
        try {
            Thread.sleep(new Random().nextInt(maxSleepTimeout) + minSleepTimeout);
            System.out.printf("%s finished %s.\n", threadName, chore);
        } catch (InterruptedException e) {
            throw new RuntimeException(String.format("%s was interrupted on %s.\n", threadName, chore), e);
        }
    }
}
