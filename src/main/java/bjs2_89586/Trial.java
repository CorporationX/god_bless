package bjs2_89586;

public class Trial implements Runnable {
    private static final int TRIAL_DURATION_MS = 2000;

    private final String knightName;
    private final String trialName;

    public Trial(String knightName, String trialName) {
        this.knightName = knightName;
        this.trialName = trialName;
    }

    @Override
    public void run() {
        try {
            System.out.printf("%s начинает испытание: %s%n", knightName, trialName);
            Thread.sleep(TRIAL_DURATION_MS);
            System.out.printf("%s завершил испытание: %s%n", knightName, trialName);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.printf("%s не смог пройти испытание %s из-за прерывания.%n", knightName, trialName);
        }
    }
}