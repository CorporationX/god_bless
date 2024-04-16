package faang.school.godbless.multithreading.task_6.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@AllArgsConstructor
@Getter
public class Knight {
    private static final int POOL_SIZE = 3;
    private final String name;
    private final List<Trial> trials = new ArrayList<>();

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials() {
        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);
        trials.forEach(executor::execute);
        executor.shutdown();
    }
}