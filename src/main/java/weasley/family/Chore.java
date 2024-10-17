package weasley.family;

import java.util.concurrent.TimeUnit;

public class Chore implements Runnable {
    private final String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + " запустился и выполняет задачу " + chore);

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException error) {
            System.err.println(threadName + " был прерван во время выполнения задачи: " + chore);
            error.printStackTrace();
            throw new IllegalStateException(threadName + "был прерван во время выполнения задачи: " + chore, error);
        }

        System.out.println(threadName + " обработал задачу " + chore);
    }
}
