package school.faang.BJS2_60472;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Trial implements Runnable {
    private final String knightName;
    private final String trialName;

    @Override
    public void run() {
        try {
            System.out.println(knightName + " началось испытание " + trialName);
            Thread.sleep(5000);
            System.out.println(knightName + " завершил испытание " + trialName);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Поток был прерван", e);
        }
    }
}