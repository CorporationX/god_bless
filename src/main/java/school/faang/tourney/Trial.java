package school.faang.tourney;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        try {
            System.out.println("Испытание: " + trialName + " началось для рыцаря " + knightName);
            Thread.sleep(4000);
            System.out.println("Испытание: " + trialName + " закончилось для рыцаря " + knightName);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Поток был прерван", e);
        }
    }
}
