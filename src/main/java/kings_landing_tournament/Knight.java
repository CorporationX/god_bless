package kings_landing_tournament;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Getter
public class Knight {
    private String name;
    private List<Trial> trials;
    public Knight(String name){
        this.name = name;
        trials = new ArrayList<>();
    }
    public void addTrial(Trial trial){
        trial.setKnightName(name);
        trials.add(trial);
    }
    public void startTrials() {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (var trial: trials){
            executor.submit(trial);
        }
        executor.shutdown();
    }
}
