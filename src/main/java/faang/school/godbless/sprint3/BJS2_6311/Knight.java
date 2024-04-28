package faang.school.godbless.sprint3.BJS2_6311;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Getter
@AllArgsConstructor
public class Knight {
    private final String name;
    private final List<Trial> trials = new ArrayList<>();

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials(ExecutorService executor) {
        for (Trial trial : trials) {
            executor.submit(trial);
        }
    }
}