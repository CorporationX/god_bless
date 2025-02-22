package school.faang.kingtournament;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
public class Knight {
    private static final int THREAD_COUNTER = 2;
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
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNTER);
        for (Trial trial : trials) {
            executor.execute(trial);
        }
        executor.shutdown();
    }
}
