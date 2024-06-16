package faang.school.godbless.TheKingTournament;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": " + " рыцарь - " + this.knightName + " испытание - " + this.trialName);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + ": " + " рыцарь - " + this.knightName + " завершил испытание - " + this.trialName);
    }
}
