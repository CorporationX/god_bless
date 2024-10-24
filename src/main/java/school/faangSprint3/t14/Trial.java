package school.faangSprint3.t14;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {
    private final String knightName;
    private final String trialName;

    @Override
    public void run() {
        try {
            System.out.println(knightName + " начинает испытание: " + trialName);
            Thread.sleep(2000);
            System.out.println(knightName + " завершил испытание: " + trialName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}