package faang.school.godbless.multithreading.parallelism_thread.king_tournament;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Knight implements Runnable {
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
        for (int i = 0; i < trials.size(); i++) {
            executor.submit(trials.get(i));
        }
        executor.shutdown();
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        startTrials();
    }
}
