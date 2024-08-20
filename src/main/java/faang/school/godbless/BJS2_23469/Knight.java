package faang.school.godbless.BJS2_23469;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@AllArgsConstructor
@Getter
public class Knight {
    private final String name;
    private final List<Trial> trials = new ArrayList<>();

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials(ExecutorService executor) {
        trials.forEach(executor::submit);
    }
}
