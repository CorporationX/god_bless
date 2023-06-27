package faang.school.godbless.kingHarbor;

import lombok.Data;
import lombok.NonNull;

@Data
public class Trial implements Runnable{
    @NonNull
    private String knightName;
    @NonNull
    private String trialName;

    @Override
    public void run() {
        System.out.println(knightName + " начал испытание " + trialName);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        System.out.println(knightName + " закончил испытнаие " + trialName);
    }
}
