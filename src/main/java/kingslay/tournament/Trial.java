package kingslay.tournament;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class Trial implements Runnable {
    @NonNull
    private final String knightName;
    @NonNull
    private final String trialName;

    @Override
    public void run() {
        System.out.printf("%s starts his trial! It's %s%n", knightName, trialName);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s gloriously finished his trial!%n", knightName);
    }
}
