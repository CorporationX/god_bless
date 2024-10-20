package school.faang.godbless.bjs2_35772;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Knight {
    private final List<Trial> trials = new ArrayList<>();
    @Getter
    private String name;

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials() {
        ExecutorService pool = Executors.newCachedThreadPool();
        trials.forEach(pool::submit);
        pool.shutdown();
        try {
            if (pool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS)) {
                log.info("Knight {} completed all trials", name);
            } else {
                log.error("Trials pool for knight {} is not terminated", name);
            }
        } catch (InterruptedException e) {
            log.warn("Interrupted when waiting for all trials completion");
            Thread.currentThread().interrupt();
        }
    }
}
