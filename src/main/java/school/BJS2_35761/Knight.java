package school.BJS2_35761;

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
        trial.setKnightName(name);
    }

    public void startTrial() {
        int sizeOfThreads = trials.size();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(sizeOfThreads);
        for (Trial trial : trials) {
            fixedThreadPool.execute(trial);
        }
        fixedThreadPool.shutdown();
    }
}
