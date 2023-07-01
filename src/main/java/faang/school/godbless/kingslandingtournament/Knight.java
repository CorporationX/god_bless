import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
public class Knight {
    private String name;
    private List<Trial> trials = new ArrayList<>();
    private ExecutorService executor = Executors.newFixedThreadPool(2);

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials() {
        trials.forEach(trial -> executor.submit(trial));
        executor.shutdown();
    }
}
