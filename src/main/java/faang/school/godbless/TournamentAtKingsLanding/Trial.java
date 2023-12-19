package faang.school.godbless.TournamentAtKingsLanding;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println("Iспытание " + trialName + " выполняется рыцарем " + knightName + " в потоке " + Thread.currentThread().getName());
    }
}