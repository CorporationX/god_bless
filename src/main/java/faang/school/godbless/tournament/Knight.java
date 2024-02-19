package faang.school.godbless.tournament;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
@RequiredArgsConstructor
public class Knight {

    private final String name;
    private List<Trial> trials = new ArrayList<>();

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials() {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (var trial : trials) {
            executor.execute(trial);
        }
    }
}
