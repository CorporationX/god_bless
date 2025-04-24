package src.faang.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public class Knight {
    @Getter
    private final String name;
    private final List<Trial> trials = new ArrayList<>();

    public void add(Trial trial) {
        trials.add(trial);
    }

    public void startsTrial() {
        final ExecutorService executor = Executors.newFixedThreadPool(trials.size());

        for (Trial trial : trials) {
            executor.execute(trial);
        }

        try {
            if (executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
        }

        executor.shutdown();
    }
}
