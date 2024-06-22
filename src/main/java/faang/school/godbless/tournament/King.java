package faang.school.godbless.tournament;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static int THREAD_POOL_SIZE = 2;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        List<Knight> knightList = getKnightList();

        knightList.forEach(executorService::execute);

        executorService.shutdown();
    }

    private static List<Knight> getKnightList(){
        Knight knightJohn = new Knight("John");
        Knight knightRoger = new Knight("Roger");

        Trial firstTrialForJohn = new Trial("Kill the Lion");
        Trial firstTrialForRoger = new Trial("Kill the Anaconda");
        Trial secondTrialForJohn = new Trial("Overcome cold");
        Trial secondTrialForRoger = new Trial("Overcome fire");

        knightJohn.addTrial(firstTrialForJohn);
        knightJohn.addTrial(secondTrialForJohn);
        knightRoger.addTrial(firstTrialForRoger);
        knightRoger.addTrial(secondTrialForRoger);

        return List.of(knightJohn, knightRoger);
    }
}
