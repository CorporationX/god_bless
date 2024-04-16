package tournament;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Data
public class Knight {
    private String name;
    private List<Trial> trials;

    public Knight(String name) {
        this.name = name;
        this.trials = new ArrayList<>();
    }

    public void addTrial(Trial trial) {
        if (trial == null) throw new NullPointerException("Trial must not be null");
        this.trials.add(trial);
    }

    public void startTrial() {
        ExecutorService executor = Executors.newCachedThreadPool();
        this.trials.forEach((executor::execute));
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();
    }
}
