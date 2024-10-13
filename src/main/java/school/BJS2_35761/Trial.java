package school.BJS2_35761;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Trial implements Runnable {

    private String knightName;
    private String trialName;

    @Override
    public void run() {
        try {
            System.out.printf("Испытание %s для %s началось!", trialName, knightName);
            System.out.println();
            Thread.sleep(5000);
            System.out.printf("Испытание %s для %s закончилось!", trialName, knightName);
            System.out.println();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
