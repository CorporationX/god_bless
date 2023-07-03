package Multithreading.bc2335;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Trial implements Runnable{
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        try {
            System.out.println("Knight: " + getKnightName() + " performs: " + getTrialName());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Knight: " + getKnightName() + " finished: " + getTrialName());

    }
}
