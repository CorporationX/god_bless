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
    private ExecutorService executor = Executors.newFixedThreadPool(2);

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials() {
        trials.forEach(executor::execute);
    }
}
