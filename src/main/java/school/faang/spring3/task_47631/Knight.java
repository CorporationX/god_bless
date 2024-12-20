package school.faang.spring3.task_47631;

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
        this.trials = new ArrayList<>();
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrial(ExecutorService service) {
        trials.forEach(service::execute);
    }
}
