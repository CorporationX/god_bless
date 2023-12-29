package faang.school.godbless.alexbulgakoff.multithreading.parallelism.tournamentinkingslanding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Alexander Bulgakov
 */

public class King {
    public static void main(String[] args) {
        Knight aris = new Knight("Aris Okhart");
        Knight jamie = new Knight("Jamie Lanister");

        Trial trialArisFirst = new Trial("Aris", "Spear Fight");
        Trial trialArisSecond = new Trial("Aris", "Archery");

        Trial trialJamieFirst = new Trial("Jamie", "Sword Fighting");
        Trial trialJamieSecond = new Trial("Jamie", "Horseback Riding");

        aris.addTrial(trialArisFirst);
        aris.addTrial(trialArisSecond);

        jamie.addTrial(trialJamieFirst);
        jamie.addTrial(trialJamieSecond);


        ExecutorService executorService = Executors.newFixedThreadPool(2);
        aris.startTrials(executorService);
        jamie.startTrials(executorService);

        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("All trials is over!!!");
    }
}
