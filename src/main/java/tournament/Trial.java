package tournament;

import lombok.AllArgsConstructor;

import java.util.Random;


@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println(String.format("%s start of trial: '%s'", this.knightName, this.trialName));
        try {
            Thread.sleep(new Random().nextInt(1, 10));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(String.format("%s finished trial: '%s'", this.knightName, this.trialName));

    }
}
