package faang.school.godbless.bjs2_23503;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class Knight {
    @Getter
    private final String name;
    private final List<Trial> trials;

    public Knight(String name) {
        this.name = name;
        trials = new ArrayList<>();
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials(ExecutorService executorService) {
        trials.forEach(executorService::submit);
    }
}
