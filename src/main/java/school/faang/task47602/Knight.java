package school.faang.task47602;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class Knight {
    @Getter
    private final String name;
    private final List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        if (trial == null) {
            throw new IllegalArgumentException("trial can`t be null");
        }

        trials.add(trial);
    }

    public void startTrials(ExecutorService executorService) {
        if (executorService == null) {
            throw new IllegalArgumentException("executorService can`t be null");
        }

        if (trials.isEmpty()) {
            throw new IllegalArgumentException("trials can`t be null or empty");
        }

        trials.forEach(executorService::execute);
    }
}
