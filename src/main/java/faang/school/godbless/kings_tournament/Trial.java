package faang.school.godbless.kings_tournament;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.printf("%s started his trial: %s from %s\n", this.knightName, this.trialName, Thread.currentThread().getName());
        try {
            Thread.sleep(new Random().nextInt(2000, 3000));
        } catch (InterruptedException e) {
            throw new RuntimeException(String.format("%s. Trial failed: %s '%s'", Thread.currentThread().getName(), this.knightName, this.trialName));
        }
        System.out.printf("%s trial finished: %s from %s\n", this.knightName, this.trialName, Thread.currentThread().getName());
    }
}
