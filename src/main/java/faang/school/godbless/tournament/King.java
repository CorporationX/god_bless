package faang.school.godbless.tournament;

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

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        executor.submit(knightJohn::startTrials);
        executor.submit(knightRoger::startTrials);

        executor.shutdown();
    }
}
