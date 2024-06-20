package faang.school.godbless.tournament;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static int THREAD_POOL_SIZE = 2;

    public static void main(String[] args) {
        Knight knightJohn = new Knight("John");
        Knight knightRoger = new Knight("Roger");

        Trial firstTrialForJohn = new Trial(knightJohn.getName(), "Kill the Lion");
        Trial firstTrialForRoger = new Trial(knightRoger.getName(), "Kill the Anaconda");
        Trial secondTrialForJohn = new Trial(knightJohn.getName(), "Overcome cold");
        Trial secondTrialForRoger = new Trial(knightRoger.getName(), "Overcome fire");

        knightJohn.addTrial(firstTrialForJohn);
        knightJohn.addTrial(secondTrialForJohn);
        knightRoger.addTrial(firstTrialForRoger);
        knightRoger.addTrial(secondTrialForRoger);

        startTrials(List.of(knightJohn, knightRoger));
    }

    public static void startTrials(List<Knight> candidates) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        candidates.forEach(
                candidate -> candidate.getTrials()
                        .forEach(executorService::execute)
        );

        executorService.shutdown();
    }
}
