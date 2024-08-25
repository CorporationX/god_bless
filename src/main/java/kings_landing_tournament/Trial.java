package kings_landing_tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    public void run() {
        try {
            System.out.printf("Испытание '%s' для рыцаря %s началось%n", trialName, knightName);
            Thread.sleep(1000);
            System.out.printf("Испытание '%s' для рыцаря %s завершилось%n", trialName, knightName);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
