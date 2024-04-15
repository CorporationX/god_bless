package faang.school.godbless.RoyalTournament;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println(trialName + " начинается!");
        try {
            Thread.sleep(new Random().nextInt(1000, 10000));
        } catch (InterruptedException e) {
            System.out.println(trialName + " прервано!");
            return;
        }
        System.out.println(trialName + " завершено!");
    }
}
