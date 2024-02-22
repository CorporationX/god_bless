package faang.school.godbless.royalHarbor;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
public class Knight {
    private String name;
    private List<Trial> trials;

    public Knight(String name) {
        this.name = name;
        this.trials = new ArrayList<>();
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials() {
        try {
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            for (Trial trial : trials) {
                executorService.submit(trial);
            }
            executorService.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
