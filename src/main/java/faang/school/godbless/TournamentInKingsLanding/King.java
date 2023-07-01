package faang.school.godbless.TournamentInKingsLanding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight knight1 = new Knight("Knight1");
        knight1.addTrial("TrialForKnight1");
        Knight knight2 = new Knight("Knight2");
        knight2.addTrial("TrialForKnight2");
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(knight1::startTrials);
        executorService.submit(knight2::startTrials);
        executorService.shutdown();
    }
}
