package faang.school.godbless.NicePoor;

import java.util.Random;

public class Chore implements Runnable {
    private final String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        System.out.println(chore + " выполняется в потоке " + Thread.currentThread().getName());
        try {
            Thread.sleep(new Random().nextInt(1000, 10000));
        } catch (InterruptedException e) {
            System.out.println(chore + " - не выполнено");
            return;
        }
        System.out.println(chore + " - выполнено");
    }
}
