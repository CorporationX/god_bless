package faang.school.godbless.parallelism.kingtournament;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Knight {
    private String name;
    private final List<Trial> trials = new ArrayList<>();

    public void addCopyOfTrial(Trial trial) {
        Trial trialCopy = trial.copy();
        trialCopy.setKnightName(name);
        trials.add(trialCopy);
    }

    public void startTrials() {
        trials.forEach(Trial::run);
    }
}
