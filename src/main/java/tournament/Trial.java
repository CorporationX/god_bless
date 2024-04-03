package tournament;

import java.util.Random;

public class Trial implements Runnable {
    private String knightName;
    private String trialName;
    private Random random = new Random();
    private int minDelay = 1000;
    private int maxDelay = 5000;

    @Override
    public void run() {
        try {
            int timer = random.nextInt(minDelay, maxDelay);
            Thread.sleep(timer);
            System.out.println(knightName + " выполнил: " + trialName + " за " + timer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Trial(String knightName, String trialName) {
        this.knightName = knightName;
        this.trialName = trialName;
    }
}
