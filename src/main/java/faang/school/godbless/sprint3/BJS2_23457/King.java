package faang.school.godbless.sprint3.BJS2_23457;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        List<Knight> knights = new ArrayList<>(List.of(
                new Knight("Royan The Ferocious"),
                new Knight("Cyrustan The Chivalric")
        ));

        knights.forEach(k -> {
                    int trialNum = 1;
                    k.addTrial(new Trial(k.getName(), String.format("trial %d", trialNum++)));
                    k.addTrial(new Trial(k.getName(), String.format("trial %d", trialNum++)));
                });

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        knights.forEach(k -> k.startTrials(executorService));
        executorService.shutdown();
    }
}
