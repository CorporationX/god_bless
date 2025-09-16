package school.faang.bjs2_89569;

public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    public Trial(String name, String trialName) {
        this.knightName = name;
        this.trialName = trialName;
    }

    public void run() {
        System.out.println("Trial " + trialName + " for " + knightName + " start.");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Trial " + trialName + " for " + knightName + " finished.");
    }
}
