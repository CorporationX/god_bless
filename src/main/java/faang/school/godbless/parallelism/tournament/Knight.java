package faang.school.godbless.parallelism.tournament;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;


public class Knight {
    private String name;
    private List<Trial> trials;

    public Knight(String name) {
        this.name = name;
        trials = new ArrayList<>();
    }

    public void startTrials(ExecutorService executorService) {
        trials.forEach(executorService::submit);
    }

    public void addTrial(Trial trial) {
        if (trial == null) {
            return;
        }

        trials.add(trial);
    }
}
