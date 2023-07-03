package faang.school.godbless.multithreadingS4.royalHarbor;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Knight {

    @Getter
    private final String name;
    private List<Trial> trials;

    public Knight(String name) {
        this.name = name;
        trials = new ArrayList<>();
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        trials.forEach(executorService::submit);
        executorService.shutdown();
    }
}
