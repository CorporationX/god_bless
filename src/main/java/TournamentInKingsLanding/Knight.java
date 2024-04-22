package TournamentInKingsLanding;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
public class Knight {
    private String name;
    private List<Trial> trials;

    public Knight(String name) {
        this.name = name;
        trials = new ArrayList<>();
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials()  {
        ExecutorService executors = Executors.newCachedThreadPool();
        trials.forEach(trial -> executors.execute(trial));
        executors.shutdown();
    }
}
