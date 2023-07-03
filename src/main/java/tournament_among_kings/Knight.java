package tournament_among_kings;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
public class Knight {
    private final String name;
    private final List<Trial> trials;

    public Knight(String name) {
        this.name = name;
        trials = new ArrayList<>();
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials() {
        ExecutorService executorService = Executors.newFixedThreadPool(trials.size());
        for (Trial trial : trials) {
            executorService.submit(trial);
        }
        executorService.shutdown();
    }

}
