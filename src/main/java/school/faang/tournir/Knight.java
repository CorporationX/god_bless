package school.faang.tournir;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Data
public class Knight {
    private String name;
    private List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        if (trial == null) {
            throw new IllegalArgumentException("Trial cannot be null");
        }
        trials.add(trial);
    }

    public void startTrials(ExecutorService executorService) {
        if (executorService == null) {
            throw new IllegalArgumentException("ExecutorService cannot be null");
        }
        if (trials.isEmpty()) {
            throw new IllegalStateException("No Trial for execution");
        }
        for (Trial trial : trials) {
            if (trial == null) {
                throw new IllegalStateException("Trial at List trials is null");
            }
            executorService.submit(trial);
        }
    }

}
