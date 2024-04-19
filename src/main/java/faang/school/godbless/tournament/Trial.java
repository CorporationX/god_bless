package faang.school.godbless.tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Trial implements Runnable{
    private String knightName;
    private String trialName;


    @Override
    public void run() {
        System.out.println(knightName + " завершает испытание: " + trialName);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(knightName + " провалил задание");
        }
    }
}
