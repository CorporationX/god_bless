package faang.school.godbless.r_edzie.parallelism.trials;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Data
public class Knight {
    private static final int TERMINATION_TIMEOUT = 5;
    private String name;
    private List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public Runnable startTrials() {
        return () -> {
            ExecutorService executors = Executors.newCachedThreadPool();
            for (Trial trial : trials) {
                executors.submit(trial);
            }

            try {
                executors.awaitTermination(TERMINATION_TIMEOUT, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            executors.shutdown();
        };
    }
}
