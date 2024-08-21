package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Knight {

    private String name;
    private final List<Trial> trials = new ArrayList<>();


    public Knight(String name) {
        this.name = name;
    }


    public void addTrial(Trial trial) {
        trials.add(trial);
    }


    public void startTrials() {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        for (Trial trial : trials) {
            threadPool.submit(() -> {
                System.out.println(name + " is starting trial: " + trial.getTrialName());
                trial.run(name);
                System.out.println(name + " completed trial: " + trial.getTrialName());
            });
        }

        threadPool.shutdown();
    }
}
