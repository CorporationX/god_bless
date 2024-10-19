package school.faang.kings_landing_tourney_BJS2_35750;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static void main(String[] args) {
        final int THREAD_COUNT = 2;
        final int AWAITING_TIME = 1;

        Knight knight1 = new Knight("Sir Lancelot", new ArrayList<>());
        Knight knight2 = new Knight("Sir Percival", new ArrayList<>());

        knight1.addTrial(new Trial("Sir Lancelot", "Trial of Endurance"));
        knight1.addTrial(new Trial("Sir Lancelot", "Trial of Honor"));
        knight2.addTrial(new Trial("Sir Percival", "Trial of Purity"));
        knight2.addTrial(new Trial("Sir Percival", "Trial of Courage"));

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

        List<Knight> knights = new ArrayList<>(Arrays.asList(knight1, knight2));

        for (Knight knight : knights) {
            executorService.execute(knight::startTrials);
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(AWAITING_TIME, TimeUnit.MINUTES)) {
                System.out.println("Awaiting time is over , forcing shutdown");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted execution");
            e.printStackTrace();
        }
    }
}
