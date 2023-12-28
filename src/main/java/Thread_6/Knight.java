package Thread_6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Knight {

    private String name;
    private ExecutorService executor = Executors.newFixedThreadPool(2);

    public Knight(String name) {
        this.name = name;
    }

    private List<Trial> trials = new ArrayList<>();

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials() {
        for (Trial trial : trials) {
            executor.submit(trial);
        }
        executor.shutdown();
    }

    public String getName() {
        return name;
    }

}
