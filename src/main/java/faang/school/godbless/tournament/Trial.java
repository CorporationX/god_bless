package faang.school.godbless.tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Trial implements Runnable {

    private final String trialName;
    private final String knightName;

    private final long TIME_FOR_TRIAL = 2000L;

    @Override
    public void run() {
        try {
            System.out.println("Trial " + trialName + " has been started by " + knightName);
            Thread.sleep(TIME_FOR_TRIAL);
            System.out.println("Trial " + trialName + " has been finished by " + knightName);
        } catch (InterruptedException interruptedException) {
            System.out.println("Oops " + trialName + " won't finished");
        }
    }
}
