package faang.school.godbless.royal.tournament;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static final int TIME_FOR_WHOLE_TOURNAMENT_IN_SECONDS = 5;

    public static void main(String[] args) {
        List<Knight> knights = List.of(new Knight("Artur"), new Knight("Richard"));

        for (Knight knight : knights) {
            knight.addTrial(new Trial("Horse racing"));
            knight.addTrial(new Trial("Archery"));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(knights.size());
        try {
            knights.forEach(knight -> executorService.submit(knight::startTrials));
        } finally {
            executorService.shutdown();
            try {
                if (!executorService.awaitTermination(TIME_FOR_WHOLE_TOURNAMENT_IN_SECONDS, TimeUnit.SECONDS)) {
                    executorService.shutdownNow();
                }
            } catch (InterruptedException e) {
                executorService.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }

    }
}
