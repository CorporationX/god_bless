package faang.school.godbless.parallelism.tournament;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Knight {
    private final String name;
    private final List<Trial> trials;

    public Knight(String name) {
        this.name = name;
        trials = new ArrayList<>();
    }

    public void startTrials() {
        ExecutorService executorService = Executors.newFixedThreadPool(trials.size());

        trials.forEach(executorService::submit);

        executorService.shutdown();
    }

    public void addTrial(Trial trial) {
        if (trial == null) {
            return;
        }

        trials.add(trial);
    }
}
