package faang.school.godbless.task.tournament;

import java.util.ArrayList;
import java.util.List;

public class Knight implements Runnable {
    private final String name;
    private final List<Trial> trials;

    public Knight(String name) {
        this.name = name;
        this.trials = new ArrayList<>();
    }

    public void addTrial(Trial trial) {
        this.trials.add(trial);
    }

    public void startTrials() {
        for (var trial : trials) {
            System.out.println(trial.getKnightName() + ": " + trial.getTrialName());
        }
    }

    @Override
    public void run() {
        startTrials();
    }
}
