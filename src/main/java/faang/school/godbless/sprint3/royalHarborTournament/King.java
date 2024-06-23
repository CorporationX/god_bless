package faang.school.godbless.sprint3.royalHarborTournament;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {

    public static void main(String[] args) {
        Knight knight1 = new Knight("knight1", new ArrayList<>());
        Knight knight2 = new Knight("knight2", new ArrayList<>());

        Trial trial1 = new Trial(knight1.getName(), "trial1");
        Trial trial2 = new Trial(knight1.getName(), "trial2");
        Trial trial3 = new Trial(knight2.getName(), "trial3");
        Trial trial4 = new Trial(knight2.getName(), "trial4");

        knight1.addTrial(trial1).addTrial(trial2);
        knight2.addTrial(trial3).addTrial(trial4);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        knight1.startTrials(executorService);
        knight2.startTrials(executorService);

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
                System.out.println("Trials aren't done");
                executorService.shutdownNow();
            } else {
                System.out.println("Trials are done");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
