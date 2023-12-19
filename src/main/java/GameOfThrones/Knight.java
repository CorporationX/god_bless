package GameOfThrones;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Getter
public class Knight {
    private final String name;
    private List<Trial> trials;

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        if (trials == null || trials.isEmpty()) {
            trials = new ArrayList<>();
        }
        trials.add(trial);
    }

    public void startTrials(ExecutorService executorService) {
        System.out.println(name + " is starting Trials!");
        for (Trial trial : trials) {
            executorService.submit(trial);
        }
    }
}
