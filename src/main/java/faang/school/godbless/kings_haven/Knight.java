package faang.school.godbless.kings_haven;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@AllArgsConstructor
public class Knight{
    private final String name;
    private List<Trial> trials;

    public void addTrial(Trial trial){
        trials.add(trial);
    }

    public void startTrials(){
        ExecutorService executor = Executors.newCachedThreadPool();
        trials.stream().forEach(trial -> executor.submit(trial));
        executor.shutdown();
    }
}