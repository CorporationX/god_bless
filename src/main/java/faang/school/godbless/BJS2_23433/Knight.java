package faang.school.godbless.BJS2_23433;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class Knight {
    @Getter
    private String name;
    private List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        if (trial == null) {
            throw new IllegalArgumentException("No trials were found");
        }

        trials.add(trial);
    }


    public void startTrials(ExecutorService service) {
        this.trials.forEach(trial -> service.submit(() -> trial.run()));
    }
}
