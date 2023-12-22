package faang.school.godbless.tournament;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Knight {
    private String name;
    private List<Trial> trials;

    public Knight(String name) {
        this.name = name;
        this.trials = new ArrayList<>();
    }

    void addTrial(Trial trial) {
        trials.add(trial);
    }

    void startTrials() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (Trial trial : trials) {
            executorService.submit(trial);
        }
        executorService.shutdown();
    }
}
