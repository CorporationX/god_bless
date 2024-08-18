package faang.school.godbless.BJS2_23750;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@AllArgsConstructor
public class Knight {

    private String name;
    public List<Trial> trials;

    public void startTrials() {
        ExecutorService executor = Executors.newFixedThreadPool(trials.size());
        trials.forEach(executor::execute);
        executor.shutdown();
    }
}
