package faang.school.godbless.spring_4.kings_landing_tournament;

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
        trials.add(trial);
    }

    public void startTrials(ExecutorService pool) {
        trials.forEach(pool::submit);
    }

}
