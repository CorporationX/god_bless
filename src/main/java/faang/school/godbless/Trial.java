package faang.school.godbless;

import lombok.Getter;

@Getter
public class Trial {

    private final String knightName;
    private final String trialName;


    public Trial(String knightName, String trialName) {
        this.knightName = knightName;
        this.trialName = trialName;
    }


    public void run(String knightName) {
        System.out.println(knightName + " is performing trial: " + trialName);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(knightName + "'s trial was interrupted!");
            return;
        }
        System.out.println(knightName + " completed trial: " + trialName);
    }
}