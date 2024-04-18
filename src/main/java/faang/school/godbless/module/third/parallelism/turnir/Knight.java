package faang.school.godbless.module.third.parallelism.turnir;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.Getter;

@Getter
public class Knight {
    private String name;
    private List<Trial> trials = new ArrayList<>();
    
    public Knight(String name) {
        this.name = name;
    }
    
    public void addTrial(Trial trial) {
        trials.add(trial);
    }
    
    public void startTrials() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        trials.forEach((trial) -> executorService.execute(trial));
        executorService.shutdown();
    }
}
