package Kings_Landing_Tournament;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Knight {
    private String name;
    private List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public String getName() {
        return name;
    }

    public List<Trial> getTrials() {
        return trials;
    }

    public void startTrials() {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (Trial trial : trials) {
            executor.execute(trial);
        }
        executor.shutdown();
    }
}
