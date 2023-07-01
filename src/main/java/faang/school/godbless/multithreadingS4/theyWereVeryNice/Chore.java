package faang.school.godbless.multithreadingS4.theyWereVeryNice;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Chore implements Runnable {
    private String taskName;

    @Override
    public void run() {
        System.out.printf("Thread - %s start.%n",
                Thread.currentThread().getName());

        try {
            Thread.sleep(new Random().nextInt(50) * 250);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("\tThread - %s has finished working.%n",
                Thread.currentThread().getName());
    }
}
