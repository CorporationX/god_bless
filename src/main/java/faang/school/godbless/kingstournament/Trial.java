package faang.school.godbless.kingstournament;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    public void run() {
        System.out.println(knightName + "  делает " + trialName);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(knightName + "  завершил " + trialName);
    }
}
