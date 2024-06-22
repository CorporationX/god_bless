package faang.school.godbless.thread6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public record Knight(String name, List<Trial> trials) {

    private static final int NUMBER_OF_THREADS = 2;

    public Knight(String name) {
        this(name, new ArrayList<>());
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials() {
        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        trials.forEach(executor::submit);
        executor.shutdown();
    }
}
