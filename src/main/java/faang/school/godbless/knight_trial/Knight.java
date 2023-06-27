package faang.school.godbless.knight_trial;

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
        ExecutorService executor = Executors.newFixedThreadPool(trials.size());

        for (Trial trial : trials) {
            executor.submit(trial);
        }

        executor.shutdown();
    }
}
