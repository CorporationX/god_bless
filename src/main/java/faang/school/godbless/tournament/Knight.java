package faang.school.godbless.tournament;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Data
@RequiredArgsConstructor
public class Knight {
    private final String name;
    private List<Trial> trials = new ArrayList<>();

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials() {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (Trial trial : trials) {
            executor.execute(trial);
        }

        executor.shutdown();
    }
}


