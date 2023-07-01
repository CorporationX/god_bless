package faang.school.godbless.multithreading.tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println(knightName + " начинает испытание " + trialName);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.err.println("Испытание прервано");
        }

        System.out.println(knightName + " заканчивает испытание " + trialName);
    }
}
