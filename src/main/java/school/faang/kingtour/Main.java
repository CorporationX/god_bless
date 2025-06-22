package school.faang.kingtour;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Danil Pudovkin
 * @since 21.06.2025
 */
public class Main {

    private static final int MAX_EXECUTOR_AWAIT_TERMINATION_TIME = 2;

    public static void main(String[] args) {
        var knight1Name = "Knight 1";
        var knight2Name = "Knight 2";
        var knight1 = new Knight(knight1Name);
        var knight2 = new Knight(knight2Name);
        knight1.addTrial(new Trial(knight1Name, "Trial 1"));
        knight1.addTrial(new Trial(knight1Name, "Trial 2"));
        knight2.addTrial(new Trial(knight2Name, "Trial 3"));
        knight2.addTrial(new Trial(knight2Name, "Trial 4"));

        var executor = Executors.newFixedThreadPool(MAX_EXECUTOR_AWAIT_TERMINATION_TIME);
        knight1.startTrials(executor);
        knight2.startTrials(executor);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(MAX_EXECUTOR_AWAIT_TERMINATION_TIME, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
        }
    }
}
