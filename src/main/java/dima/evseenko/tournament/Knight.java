package dima.evseenko.tournament;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Data
@AllArgsConstructor
public class Knight {
    private final List<Trial> trials = new ArrayList<>();

    private String name;

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials(ExecutorService executor) {
        trials.forEach((executor::submit));
    }
}
