package faang.school.godbless.Parallelism.KingLandingTournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight knight1 = new Knight("Herald");
        Knight knight2 = new Knight("Malcolm");

        knight1.addTrial(new Trial("Herald", "Kill dragon"));
        knight1.addTrial(new Trial("Herald", "Gather dragon eggs"));
        knight1.addTrial(new Trial("Herald", "Cook Omelette"));
        knight2.addTrial(new Trial("Malcolm", "Kill orcs"));
        knight2.addTrial(new Trial("Malcolm", "Take seeds"));
        knight2.addTrial(new Trial("Malcolm", "Plant seeds"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        knight1.startTrials(executorService);
        knight2.startTrials(executorService);

        executorService.shutdown();
    }
}
