package tourneyAtKingsLanding_35756;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Trial implements Runnable {
    private final String knightName;
    private final String trialName;

    @Override
    public void run() {
        System.out.println("Испытание " + trialName + " началось!");
        try {
            Thread.sleep(5000);
            System.out.println(knightName + " прошел испытание " + trialName);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
