package faang.school.godbless.Sprint_3.Multythreading.Tournament;

public class Trial implements Runnable{
    private String knightName;
    private String trialName;

    public Trial(String knightName, String trialName) {
        this.knightName = knightName;
        this.trialName = trialName;
    }

    @Override
    public void run() {
        System.out.printf("Knight: %s is doing: %s\n",  knightName, trialName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Trial: %s Has been completed by %s\n", trialName, knightName);
    }
}
