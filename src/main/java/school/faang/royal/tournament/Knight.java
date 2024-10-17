package school.faang.royal.tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
@AllArgsConstructor
@Slf4j
public class Knight {
    private String name;
    private final List<Trial> trials = new ArrayList<>();

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        trials.forEach(executor::submit);
        executor.shutdown();
    }
}
