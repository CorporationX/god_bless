package faang.school.godbless.sprint_3.they_were_nice;

import java.util.Random;

public class Chore implements Runnable {
    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        System.out.printf("%s -> %s\n", Thread.currentThread().getName(), chore);
        try {
            Thread.sleep(new Random().nextInt(5000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
        System.out.printf("%s -> completed\n", chore);
    }
}