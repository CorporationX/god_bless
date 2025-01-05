package school.faang.task_48173;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
public class Knight {
    private final String name;
    private final List<Trial> trials;

    public Knight(String name) {
        this.name = name;
        this.trials = new ArrayList<>();
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials() {
        ExecutorService executorService = Executors.newFixedThreadPool(trials.size());
        System.out.printf("Thread %s has started event: \"The trial for %s is start!\"\n",
                Thread.currentThread().getName(), name);
        for (Trial trial : trials) {
            executorService.execute(trial);
        }
        executorService.shutdown();
    }
}
