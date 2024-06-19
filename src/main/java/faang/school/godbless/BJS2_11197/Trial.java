package faang.school.godbless.BJS2_11197;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class Trial implements Runnable{
    private String knightName;
    private String trialName;


    @Override
    public void run() {
        System.out.println("Рыцарь - " + knightName + " начал испытание - " + trialName);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Рыцарь - " + knightName + " завершил испытание - " + trialName);
    }

}
