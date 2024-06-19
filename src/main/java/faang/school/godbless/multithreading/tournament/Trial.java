package faang.school.godbless.multithreading.tournament;

public record Trial(String knightName, String trialName) implements Runnable {
    @Override
    public void run() {
        System.out.printf("Trial %s performs by %s.\n", trialName, knightName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.printf("Trial %s is interrupted. Knight %s can not proceed with trial.\n", trialName, knightName);
            return;
        }
        System.out.printf("%s passed the %s successfully!\n", knightName, trialName);
    }
}
