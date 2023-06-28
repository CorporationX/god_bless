package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
@Getter
@AllArgsConstructor
public class Knight {
    private String name;
    private List<Trial> trials;
    public void addTrial(Trial trial){
        trials.add(trial);
    }
    public void startTrials() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(Math.min(trials.size(), 10));
        trials.forEach(executor::submit);
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);
    }
}
