package faang.school.godbless.alexbulgakoff.multithreading.parallelism.tournamentinkingslanding;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Alexander Bulgakov
 */
@AllArgsConstructor
@Getter
@ToString
public class Trial implements Runnable {

    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println(knightName + " trial: " + trialName + " has begun!");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Trial: " + trialName + " is over!");
    }
}
