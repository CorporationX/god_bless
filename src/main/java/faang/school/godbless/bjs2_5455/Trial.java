package faang.school.godbless.bjs2_5455;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Trial implements Runnable {

    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println("Running trial: " + trialName + " for knight: " + knightName);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
