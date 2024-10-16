package school.faang.kingstournament;

public record Trial(String knightName, String trialName) implements Runnable {
    @Override
    public void run() {
        System.out.println("Trial started " + trialName);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
