package faang.school.godbless.BJS210929;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {

    public static void main(String[] args) {

        Knight knight1 = new Knight("Knight1");
        Knight knight2 = new Knight("Knight2");

        Trial trial1 = new Trial("trial1");
        Trial trial2 = new Trial("trial2");
        Trial trial3 = new Trial("trial3");
        Trial trial4 = new Trial("trial4");

        knight1.addTrial(trial1);
        knight1.addTrial(trial3);
        knight2.addTrial(trial2);
        knight2.addTrial(trial4);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(knight1::startTrials);
        executorService.execute(knight2::startTrials);
        executorService.shutdown();

    }
}
