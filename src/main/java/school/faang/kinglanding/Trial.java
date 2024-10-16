package school.faang.kinglanding;

public record Trial(String knightName, String trialName) implements Runnable {
    @Override
    public void run() {
        System.out.printf("\n%s - испытание для: %s, началось",
                trialName, knightName);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
