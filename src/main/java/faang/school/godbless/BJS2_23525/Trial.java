package faang.school.godbless.BJS2_23525;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.printf("%s knight starts trial %s%n", knightName, trialName);
        System.out.printf("%s Knight has finished the trial %s%n", knightName, trialName);
        System.out.println("=========================================");
    }
}