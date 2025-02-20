package school.faang.BJS2_60461;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        try {
            System.out.printf("%s начал испытание \"%s\"\n", knightName, trialName);
            Thread.sleep(new Random().nextInt(1000, 5000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
