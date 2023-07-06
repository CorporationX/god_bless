package faang.school.godbless.Sprint4.TournamentKingsLanding;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @SneakyThrows
    @Override
    public void run() {
        System.out.printf("Knight - %s is starting %s \n",knightName, trialName);
        Thread.sleep((long) (Math.random() * 5000));
    }
}
