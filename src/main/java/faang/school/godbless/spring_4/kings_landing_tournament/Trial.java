package faang.school.godbless.spring_4.kings_landing_tournament;

public class Trial implements Runnable {
    private final String knightName;
    private final String trialName;

    public Trial(String knightName, String trialName) {
        this.knightName = knightName;
        this.trialName = trialName;
    }

    @Override
    public void run() {
        System.out.printf("a trial %s for a knight %s \n", trialName, knightName);
    }
}
