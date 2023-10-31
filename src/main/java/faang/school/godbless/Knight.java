package faang.school.godbless;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Getter
public class Knight {
    private String name;
    private List<Trial> trials = new ArrayList<>();
    private boolean isDone;

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials(){
        ExecutorService executor = Executors.newFixedThreadPool(trials.size());
        for(Trial trial: trials){
            executor.submit(trial);
        }

        executor.shutdown();

        try {
            isDone = executor.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
