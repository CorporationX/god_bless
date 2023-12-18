package faang.school.godbless.nicebutpoor;

import java.util.Random;

public class Chore implements Runnable {
    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        System.out.printf("%s - started on: %s \n", chore, Thread.currentThread().getName());
        try {
            Thread.sleep(new Random().nextInt(5) * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
