package faang.school.godbless.sprint3.royalHarborTournament;

public class Trial implements Runnable {

    private String knightName;
    private String trialName;

    public Trial(String knightName, String trialName) {
        this.knightName = knightName;
        this.trialName = trialName;
    }

    @Override
    public void run() {
        try {
            System.out.println("Knight " + knightName + " is starting completing trial " + trialName);
            Thread.sleep(500);
            System.out.println("Knight " + knightName + " completed trial " + trialName);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
