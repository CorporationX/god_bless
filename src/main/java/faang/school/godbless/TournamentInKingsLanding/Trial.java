package faang.school.godbless.TournamentInKingsLanding;

public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    public Trial(String knightName, String trialName) {
        this.knightName = knightName;
        this.trialName = trialName;
    }

    @Override
    public void run() {
        System.out.println(this.knightName + " is doing" + this.trialName);
    }
}
