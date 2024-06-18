package faang.school.godbless.parallelism.kingtournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight knight1 = new Knight("Knight 1");
        Knight knight2 = new Knight("Knight 2");

        Trial trial1 = new Trial("Trial 1");
        knight1.addCopyOfTrial(trial1);
        knight2.addCopyOfTrial(trial1);

        Trial trial2 = new Trial("Trial 2");
        knight1.addCopyOfTrial(trial2);
        knight2.addCopyOfTrial(trial2);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(knight1::startTrials);
        executorService.execute(knight2::startTrials);

        executorService.shutdown();
    }
}
