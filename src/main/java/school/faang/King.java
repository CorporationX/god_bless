package school.faang;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight knight1 = new Knight("knight1");
        Knight knight2 = new Knight("knight2");

        Trial trial1 = new Trial("trial1", "knight1");
        Trial trial2 = new Trial("trial1", "knight1");
        Trial trial3 = new Trial("trial3", "knight2");
        Trial trial4 = new Trial("trial4", "knight2");

        knight1.setTrials(List.of(trial1, trial2));
        knight2.setTrials(List.of(trial3, trial4));

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        knight1.startTrials(executorService);
        knight2.startTrials(executorService);
        executorService.shutdown();

    }
}
