package faang.school.godbless.multithreading_parallelism.the_tournament_at_kings_landing;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.printf("%s : %s %n", knightName, trialName);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
