package faang.school.godbless.sprint4.multithreading_parallelism_thread.task9;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Knight {

    private String name;

    private List<Trial> trials;

    public Knight(String name) {
        this.name = name;
        trials = new ArrayList<>();
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public List<Thread> startTrials() {
        return new ArrayList<>(trials);
    }
}
