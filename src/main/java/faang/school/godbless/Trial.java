package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Trial {
    private String knightName;
    private String trialName;

    public void run() {
        System.out.println(knightName + " is running the trial " + trialName);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Trial " + trialName + " was interrupted");
        }
        System.out.println(knightName + " is finished " + trialName);
    }
}