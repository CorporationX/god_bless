package Sprint_4_Tournament_in_Kings_Haven;

public class Trial implements Runnable {
    private String knightName;
    private String trialName;
    private Long trialTime;

    public Trial(String knightName, String trialName, Long trialTime) {
        this.knightName = knightName;
        this.trialName = trialName;
        this.trialTime = trialTime;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":" + " " + knightName + " has started to implement trial: " + trialName);
        try {
            Thread.sleep(trialTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + ":" + " " + knightName + " has finished to implement trial: " + trialName);

    }
}
