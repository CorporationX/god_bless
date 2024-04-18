package TournamentInKingsLanding;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("Рыцарь " + knightName + " начал испытание " + trialName);
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Рыцарь " + knightName + " закончил испытание " + trialName);
    }
}
