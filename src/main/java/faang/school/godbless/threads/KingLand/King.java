package faang.school.godbless.threads.KingLand;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight knight1 = new Knight("Воин");
        Knight knight2 = new Knight("Самурай");
        Trial trial1 = new Trial("Воин", "драка");
        Trial trial2 = new Trial("Воин", "плавание");
        Trial trial3 = new Trial("Самурай", "танец");
        Trial trial4 = new Trial("Самурай", "охота");

        knight1.addTrial(trial1);
        knight1.addTrial(trial2);

        knight2.addTrial(trial3);
        knight2.addTrial(trial4);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        knight1.startTrials(executorService);
        knight2.startTrials(executorService);
        executorService.shutdown();
    }
}
