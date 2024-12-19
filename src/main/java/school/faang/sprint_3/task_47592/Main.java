package school.faang.sprint_3.task_47592;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int TERMINATION_DELAY = 5;
    private static final int AMOUNT_OF_KNIGHTS = 5;
    private static final int AMOUNT_OF_TRIALS_PER_KNIGHT = 5;

    public static void main(String[] args) {
        List<Knight> knights = generateKnights(AMOUNT_OF_KNIGHTS, AMOUNT_OF_TRIALS_PER_KNIGHT);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (Knight knight : knights) {
            knight.startTrials(executorService);
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TERMINATION_DELAY, TimeUnit.MINUTES)) {
                System.out.println("Trials did not finished, shutting down...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }

    private static List<Knight> generateKnights(int amountOfKnights, int amountOfTrialsPerKnight) {
        List<Knight> knights = new ArrayList<>();
        for (int i = 1; i <= amountOfKnights; i++) {
            Knight knight = new Knight("Knight " + i);
            for (int j = 1; j < amountOfTrialsPerKnight; j++) {
                knight.addTrial(new Trial("Trial " + j));
            }
            knights.add(knight);
        }
        return knights;
    }
}
