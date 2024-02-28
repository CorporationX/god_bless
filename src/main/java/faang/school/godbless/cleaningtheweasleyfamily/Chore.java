package faang.school.godbless.cleaningtheweasleyfamily;

import java.util.Random;


public class Chore implements Runnable {
    private String chore;
    int threadSleepingTime = new Random().nextInt(1_0000);

    Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {

        System.out.println("Задача " + chore + " Обрабатывается в " + Thread.currentThread().getName());
        try {
            Thread.sleep(threadSleepingTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Задача " + chore + " выполнена.");
    }
}
