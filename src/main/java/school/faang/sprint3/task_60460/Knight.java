package school.faang.sprint3.task_60460;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Getter
public class Knight {
    private final List<Trial> trials = new ArrayList<>();
    private final String name;

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials(ExecutorService executor) {
        trials.forEach(executor::execute);
    }
}
