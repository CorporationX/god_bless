package BJS2_23484_TournamentInRoyalsLanding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static void main(String[] args) {
        Knight arthur = new Knight("Arthur");
        Knight ivan = new Knight("Ivan");

        arthur.addTrial(new Trial(arthur.getName(), "Take a sword with one hand"));
        arthur.addTrial(new Trial(arthur.getName(), "Run faster than others"));

        ivan.addTrial(new Trial(ivan.getName(), "Get first at the highest tower"));
        ivan.addTrial(new Trial(ivan.getName(), "Kill the dragon"));

        ExecutorService executor = Executors.newFixedThreadPool(2);

        arthur.startTrials(executor);
        ivan.startTrials(executor);
        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
