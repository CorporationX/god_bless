package faang.school.godbless.multithreading_parallelism.BJS2_6218;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor
@Getter
public class Trial implements Runnable{
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println("Running trial '" + trialName + "' for a knight " + knightName);
        try {
            Thread.sleep(new Random().nextInt(1000, 5000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
