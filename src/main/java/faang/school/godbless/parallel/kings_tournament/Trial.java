package faang.school.godbless.parallel.kings_tournament;

public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    public Trial(String knightName, String trialName) {
        this.knightName = knightName;
        this.trialName = trialName;
    }

    @Override
    public void run() {
        System.out.printf("Испытание %s выполняется рыцарем %s.\n", trialName, knightName);
    }
}



