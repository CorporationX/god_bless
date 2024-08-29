package faang.school.godbless.dolbahlop.multithreading.Parallelism;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trail implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println(knightName + " is performing the trial '" + trialName + "'");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
