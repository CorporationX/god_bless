package faang.school.godbless.domain.task_royal_harbor;

import java.util.ArrayList;
import java.util.List;

public class Knight {
    private String name;
    private List<Trial> trials;

    public Knight(String name) {
        this.name = name;
        this.trials = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials() {
        for (Trial trial : trials) {
            new Thread(trial).start();
        }
    }
}
