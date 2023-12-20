package Thread_6;

public class Trial implements Runnable {

    private String knightName;
    private String trialName;

    public Trial(String knightName, String trialName) {
        this.knightName = knightName;
        this.trialName = trialName;
    }

    public void run() {
        try {
            Thread.sleep((int) (Math.random() * 3000));
            System.out.println(knightName + " done trial: " + trialName);
        } catch (InterruptedException e) {
            System.out.println(knightName + " failed trial: " + trialName);
        }
    }

    public String getKnightName() {
        return knightName;
    }

    public String getTrialName() {
        return trialName;
    }
}
