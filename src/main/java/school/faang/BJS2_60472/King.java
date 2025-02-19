package school.faang.BJS2_60472;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static void main(String[] args) throws InterruptedException {
        Knight firstKnight = new Knight("Ахилес");
        Knight secondKnight = new Knight("Персей");

        firstKnight.addTrial(new Trial(firstKnight.getName(), "убить скелетов"));
        firstKnight.addTrial(new Trial(firstKnight.getName(), "убить ведьму"));

        secondKnight.addTrial(new Trial(secondKnight.getName(), "прогнать призраков"));
        secondKnight.addTrial(new Trial(secondKnight.getName(), "победить Дракона"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        firstKnight.startTrials(executorService);

        secondKnight.startTrials(executorService);

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}