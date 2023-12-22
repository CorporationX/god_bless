package faang.school.godbless.multithreading_parallelism.the_tournament_at_kings_landing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight knight1 = new Knight("Knight_1");
        Knight knight2 = new Knight("Knight_2");

        knight1.addTrial(new Trial(knight1.getName(), "trial_1"));
        knight1.addTrial(new Trial(knight1.getName(), "trial_2"));
        knight1.addTrial(new Trial(knight1.getName(), "trial_3"));
        knight1.addTrial(new Trial(knight1.getName(), "trial_4"));
        knight1.addTrial(new Trial(knight1.getName(), "trial_5"));


        knight2.addTrial(new Trial(knight2.getName(), "trial_6"));
        knight2.addTrial(new Trial(knight2.getName(), "trial_7"));
        knight2.addTrial(new Trial(knight2.getName(), "trial_8"));
        knight2.addTrial(new Trial(knight2.getName(), "trial_9"));
        knight2.addTrial(new Trial(knight2.getName(), "trial_10"));


        ExecutorService executorService = Executors.newFixedThreadPool(2);
        knight1.startTrials(executorService);
        knight2.startTrials(executorService);
        executorService.shutdown();
    }
}
