package school.faang.bjs2_89569;

import lombok.SneakyThrows;

public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    public Trial(String name, String trialName) {
        this.knightName = name;
        this.trialName = trialName;
    }

    @SneakyThrows
    public void run() {
        System.out.println("Trial " + trialName + " for " + knightName + " start.");
        Thread.sleep(5000);
        System.out.println("Trial " + trialName + " for " + knightName + " finished.");
    }
}
