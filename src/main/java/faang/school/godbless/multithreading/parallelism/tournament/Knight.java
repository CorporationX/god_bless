package faang.school.godbless.multithreading.parallelism.tournament;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class Knight {

    private final String name;
    private final List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        trial.setKnightName(name);
        trials.add(trial);
    }

    public void startTrials(ExecutorService executor) {
        for (Trial trial : trials) {
            executor.submit(trial);
        }
    }

}
