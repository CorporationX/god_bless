package faang.school.godbless.TourneyAtKingsLanding;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println("Knight " + knightName + " started trial: " + trialName);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Knight" + knightName + " finished trial: " + trialName);
    }
}
