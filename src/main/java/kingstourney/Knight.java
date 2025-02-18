package kingstourney;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Getter
public class Knight {
    private static final Logger logger = Logger.getLogger(Knight.class.getName());
    private final String name;
    private final List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        trials.add(Objects.requireNonNull(trial, "Trial cannot be null!"));
        logger.info(trial.getTrialName() + " added!");
    }

    public void startTrials() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (var trial : trials) {
            executorService.submit(trial);
        }

        executorService.shutdown();
        if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
            executorService.shutdownNow();
        }
    }
}
