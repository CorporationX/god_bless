package faang.school.godbless.r_edzie.parallelism.trials;

public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    public Trial(String knightName, String trialName) {
        this.knightName = knightName;
        this.trialName = trialName;
    }

    @Override
    public void run() {
        System.out.printf("%s начал испытание %s%n", knightName, trialName);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s прошел испытание %s%n", knightName, trialName);
    }
}
