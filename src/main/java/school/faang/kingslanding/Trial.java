package school.faang.kingslanding;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Trial implements Runnable{
    private static final int TIME_TO_TRIAL = 1000;

    private String knightName;
    private String trialName;

    @Override
    public void run() {
        try {
            System.out.println("Началось испытание " + trialName + " для рыцаря " + knightName);
            Thread.sleep(TIME_TO_TRIAL);
            System.out.println("Завершено испытание " + trialName + " для рыцаря " + knightName);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
