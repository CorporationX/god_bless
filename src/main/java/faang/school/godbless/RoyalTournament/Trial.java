package faang.school.godbless.RoyalTournament;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;
    private final Random random = new Random();

    @Override
    public void run() {
        System.out.println(trialName + " начинается!");
        try {
            Thread.sleep(random.nextInt(1000, 10000));
        } catch (InterruptedException e) {
            System.out.println(trialName + " прервано!");
            return;
        }
        System.out.println(trialName + " завершено!");
    }
}
