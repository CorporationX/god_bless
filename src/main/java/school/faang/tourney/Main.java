package school.faang.tourney;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Knight firstKnight = new Knight("Дункан Высокий");
        Knight secondKnight = new Knight("Бринден Талли");

        Trial trialForFirstKnight1 = new Trial(firstKnight.getName(), "бой на мечах");
        Trial trialForFirstKnight2 = new Trial(firstKnight.getName(), "Попасть в цель из лука");

        Trial trialForSecondKnight1 = new Trial(secondKnight.getName(), "бой на копьях");
        Trial trialForSecondKnight2 = new Trial(secondKnight.getName(), "Попасть в цель из лука верхом на лошади");

        firstKnight.addTrial(trialForFirstKnight1);
        firstKnight.addTrial(trialForFirstKnight2);

        secondKnight.addTrial(trialForSecondKnight1);
        secondKnight.addTrial(trialForSecondKnight2);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        firstKnight.startTrials(executorService);
        secondKnight.startTrials(executorService);

        executorService.shutdown();
        executorService.awaitTermination(3, TimeUnit.SECONDS);
    }
}
