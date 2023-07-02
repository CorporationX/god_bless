package faang.school.godbless.threads.KingLand;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.printf("Рыцарь %s выполняет испытание %s\n", knightName, trialName);
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Рыцарь %s выполнил испытание %s\n", knightName, trialName);
    }
}
