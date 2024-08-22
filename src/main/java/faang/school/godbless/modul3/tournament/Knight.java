package faang.school.godbless.modul3.tournament;

import lombok.Getter;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
public class Knight {
    private final String name;
    private final List<Trial> trials;
    private ExecutorService executorService;

    public Knight(String name, List<Trial> trials) {
        this.name = name;
        this.trials = trials;
    }

    public void startTrials() {
        executorService = Executors.newFixedThreadPool(trials.size());
        trials.forEach(executorService::submit);
        executorService.shutdown();
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }
}
