package school.faang.BJS2_60472;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RequiredArgsConstructor
public class Knight {
    private final String name;
    private final List<Trial> trials;

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void  startTrials(ExecutorService executorService) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

    }
}