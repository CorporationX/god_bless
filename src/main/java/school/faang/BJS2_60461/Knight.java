package school.faang.BJS2_60461;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@AllArgsConstructor
public class Knight {
    private final List<Trial> trials = new ArrayList<>();
    @Getter
    private String name;

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials(ExecutorService executor) {
        for (Trial trial : trials) {
            executor.submit(trial);
        }
    }
}
