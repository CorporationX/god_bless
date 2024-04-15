package faang.school.godbless.RoyalTournament;

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
        trials.add(trial);
    }

    public void startAllTrials() {
        ExecutorService pool = Executors.newFixedThreadPool(trials.size());
        trials.forEach(pool::execute);
        pool.shutdown();
    }
}
