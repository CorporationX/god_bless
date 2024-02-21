package faang.school.godbless.multithreading_parallelism.western_harbor_tournament;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
public class Knight {
    private String name;
    private List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials() {
        ExecutorService executors = Executors.newFixedThreadPool(2);
        for (int i = 0; i < trials.size(); i++) {
            executors.submit(trials.get(i));
        }
        executors.shutdown();
    }
}
