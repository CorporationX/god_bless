package faang.school.godbless;

public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    public Trial(String knightName, String trialName) {
        this.knightName = knightName;
        this.trialName = trialName;
    }

    @Override
    public void run() {
        System.out.println(knightName + " starts " + trialName + " trial");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(knightName + " has finished " + trialName + " trial");
    }
}
