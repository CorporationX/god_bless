package faang.school.godbless.tournamentInTheRoyalHarbor;

public class Trial {
    private String knightName;
    private String trialName;

    public Trial(String knightName, String trialName) {
        this.knightName = knightName;
        this.trialName = trialName;
    }

    public void run(String knightName) {
        try {
            Thread.sleep((int) (Math.random() * 2000));
            System.out.println("Knight " + knightName + "is competing in trial " + trialName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}