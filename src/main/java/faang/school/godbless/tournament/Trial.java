package faang.school.godbless.tournament;

import lombok.Data;

@Data
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    public Trial(String knightName, String trialName) {
        this.knightName = knightName;
        this.trialName = trialName;
    }

    @Override
    public void run() {
        System.out.printf("%s выполняет %s.\n", knightName, trialName);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
        System.out.printf("%s выполнил %s.\n", knightName, trialName);
    }
}