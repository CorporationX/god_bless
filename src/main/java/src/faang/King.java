package src.faang;

import src.faang.model.Knight;
import src.faang.model.Trial;
import src.faang.model.TrialType;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    private static final String DANIYAL = "Daniyal";
    private static final String LADA = "Lada";
    private static final int EXECUTOR_AWAIT_TERMINATION_IN_SECONDS = 10;
    private static final int THREAD_COUNT = 5;

    public static void main(String[] args) {
        final List<Knight> knights = getKnights();
        prepareTrialsForKnights(knights);

        final ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        executeTrials(knights, executor);

        executor.shutdown();
        awaitTermination(executor);
    }

    private static void executeTrials(List<Knight> knights, ExecutorService executor) {
        for (Knight knight : knights) {
            executor.execute(knight::startsTrial);
        }
    }

    private static void prepareTrialsForKnights(List<Knight> knights) {
        for (TrialType trialType : TrialType.values()) {
            for (Knight knight : knights) {
                knight.add(new Trial(knight.getName(), trialType.name()));
            }
        }
    }

    private static List<Knight> getKnights() {
        return List.of(
                new Knight(DANIYAL),
                new Knight(LADA)
        );
    }

    private static void awaitTermination(ExecutorService executor) {
        try {
            if (executor.awaitTermination(EXECUTOR_AWAIT_TERMINATION_IN_SECONDS, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
        }
    }
}

