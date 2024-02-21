package tournament;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Knight {
    private String name;
    private List<Trial> trials;

    public Knight(String name) {
        this.name = name;
        this.trials = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials() {
        System.out.println(name + " начал выполнять испытания!");
        ExecutorService executorService = Executors.newFixedThreadPool(trials.size());

        for (Trial trial : trials) {
            executorService.submit(trial);
        }

        executorService.shutdown();
    }
}
