package faang.school.godbless.bjs224291;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    public void run() {
        System.out.println(Thread.currentThread().getName() + " is performing task: " + this.chore);
        int randomNum = new Random().nextInt(5) + 1;
        try {
            Thread.sleep(randomNum * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " finished its task: " + this.chore + " in " + randomNum + " sec");
    }
}