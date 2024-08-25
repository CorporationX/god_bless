package faang.school.godbless.bjs223708;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    public void run() {
        System.out.println(this.knightName + " started the trial: " + this.trialName);
        System.out.println(this.knightName + " completed the trial");
    }
}