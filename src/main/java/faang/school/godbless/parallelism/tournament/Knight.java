package faang.school.godbless.parallelism.tournament;


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

    public void addTrial(Trial trial) {
        if (trial != null && trial.getKnightName().equals(this.name))
            this.trials.add(trial);
    }

    public void startTrials() {
        for (Trial trial : trials) {
            trial.run();
        }
    }
}
