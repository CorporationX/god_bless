package faang.school.godbless.kings_haven;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable{
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println(knightName + " stars " + trialName);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(knightName + " finished " + trialName);
    }
}