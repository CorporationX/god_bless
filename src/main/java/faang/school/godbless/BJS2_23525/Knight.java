package faang.school.godbless.BJS2_23525;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Getter
public class Knight {
    private String name;
    private final List<Trial> TRIALS = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        TRIALS.add(trial);
    }

    public void startTrials(ExecutorService executor) {
        TRIALS.forEach(executor::submit);
    }
}
