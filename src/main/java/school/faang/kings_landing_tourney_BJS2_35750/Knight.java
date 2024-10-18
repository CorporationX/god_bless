package school.faang.kings_landing_tourney_BJS2_35750;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@AllArgsConstructor
public class Knight {
    private String name;
    private final List<Trial> trials;

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (Trial trial : trials) {
            executorService.execute(trial::run);
        }
    }
}
