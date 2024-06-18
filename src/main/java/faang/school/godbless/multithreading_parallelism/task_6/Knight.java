package faang.school.godbless.multithreading_parallelism.task_6;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Knight {
    private final String name;
    private final List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }
}
