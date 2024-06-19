package faang.school.godbless.BJS2_10959;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    public Trial(String name) {
        this.trialName = name;
    }

    @Override
    public void run() {
        System.out.println(knightName + " has started " + trialName);
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
            System.out.println(knightName + " has finished " + trialName);
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
    }
}
