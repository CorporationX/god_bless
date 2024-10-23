package school.faang.multithreading.theTournamentAtKingsLanding;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialsName;

    @Override
    public void run() {
        try {
            System.out.println(knightName + " started the trial " + trialsName);
            Thread.sleep(6000);
            System.out.println(knightName + " finished the trial " + trialsName);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
