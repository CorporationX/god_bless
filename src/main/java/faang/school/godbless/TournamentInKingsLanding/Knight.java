package faang.school.godbless.TournamentInKingsLanding;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Knight {
    private String name;
    List<Trial> trials;

    public Knight(String name) {
        this.name = name;
        this.trials = new ArrayList<>();
    }

    public void addTrial(String trial) {
        this.trials.add(new Trial(this.name, trial));
    }

    public void startTrials() {
        ExecutorService executorService = Executors.newFixedThreadPool(this.trials.size());
        for (Trial trial : this.trials) {
            executorService.execute(trial);
            executorService.shutdown();
        }
    }
}
