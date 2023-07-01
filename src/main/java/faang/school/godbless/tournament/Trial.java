package faang.school.godbless.tournament;

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
        System.out.println("Knight " + knightName + " starts: " + trialName);

        try {
            Thread.sleep(new Random().nextInt(3000, 5000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Knight " + knightName + " has ended: " + trialName);
    }
}
