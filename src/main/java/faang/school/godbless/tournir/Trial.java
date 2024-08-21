package faang.school.godbless.tournir;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println("рыцарь " + knightName + " начал испытание " + trialName);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        System.out.println("рыцарь " + knightName + " закончил испытание " + trialName);
    }
}
