package src.faang.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@ToString
@RequiredArgsConstructor
public class Knight {
    public static final int EXECUTOR_AWAIT_TERMINATION_IN_SECONDS = 5;

    @Getter
    private final String name;
    private final List<Trial> trials = new ArrayList<>();

    public void add(Trial trial) {
        trials.add(trial);
    }

    public void startsTrial() {
        final ExecutorService executor = Executors.newFixedThreadPool(trials.size());
        executeTrial(executor);
        executor.shutdown();
        awaitTermination(executor);
    }

    private void executeTrial(ExecutorService executor) {
        for (Trial trial : trials) {
            executor.execute(trial);
        }
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
