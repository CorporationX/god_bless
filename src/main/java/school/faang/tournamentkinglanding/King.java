package school.faang.tournamentkinglanding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static void main(String[] args) {
        // Create two knights
        Knight knight1 = new Knight("Sir Robert");
        Knight knight2 = new Knight("Sir Jaime");

        knight1.addTrial(new Trial(knight1.getName(), "Jousting"));
        knight1.addTrial(new Trial(knight1.getName(), "Swordsmanship"));

        knight2.addTrial(new Trial(knight2.getName(), "Archery"));
        knight2.addTrial(new Trial(knight2.getName(), "Horse Riding"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(knight1::startTrials);
        executorService.submit(knight2::startTrials);

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Some trials did not complete in 1 minute, forcing shutdown...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted while waiting for trials to complete.");
            executorService.shutdownNow();
        }

        System.out.println("The tournament trials have ended.");
    }
}
