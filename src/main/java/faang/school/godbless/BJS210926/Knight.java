package faang.school.godbless.BJS210926;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class Knight {
    private String name;
    private List<Trial> trials;

    public Knight(String name) {
        this.name = name;
        trials = new ArrayList<>();
    }

    public void addTrial(Trial trial) {
        if (trial == null) {
            throw new IllegalArgumentException("Trial is null");
        }
        trials.add(trial);
    }

    public void startTrials(ExecutorService pool) {

        for (var trial : trials) {
            try {
                pool.submit(trial);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
