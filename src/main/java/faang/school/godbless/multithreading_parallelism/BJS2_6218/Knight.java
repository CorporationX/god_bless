package faang.school.godbless.multithreading_parallelism.BJS2_6218;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class Knight {
    private final String name;
    private final List<Trial> trials = new ArrayList<>();;

    public void addTrial(Trial trial) {
        System.out.println("Add trial '" + trial.getTrialName() + "' for a knight " + trial.getKnightName());
        trials.add(trial);
    }
}
