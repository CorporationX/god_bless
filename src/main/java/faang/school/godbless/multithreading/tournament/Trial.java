package faang.school.godbless.multithreading.tournament;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class Trial implements Runnable {

    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println(knightName + " takes " + trialName);
        try {
            Thread.sleep(new Random().nextInt(2000, 4000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(knightName + " finishes " + trialName);
    }
}
