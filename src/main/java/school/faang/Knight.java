package school.faang;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Getter
public class Knight {
    private final String name;
    private final List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        validateName(name);
        this.name = name;
    }

    public void addTrial(Trial trial) {
        validateTrial(trial);
        trials.add(trial);
    }

    public void startTrials(ExecutorService executorService) {
        for (Trial trial : trials) {
            executorService.submit(trial);
        }
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name can't be null or blank.");
        }
    }

    private void validateTrial(Trial trial) {
        if (trial == null) {
            throw new IllegalArgumentException("Trial can't be null.");
        }
    }

}
