package faang.school.godbless.kingstournament2903;

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
    }

    public void addTrial(Trial trial) {
        if (this.getTrials() == null) {
            this.trials = new ArrayList<>();
        }
        this.getTrials().add(trial);
    }

    public void startTrials() {
        ExecutorService trialExecutor = Executors.newSingleThreadExecutor();
        List<Trial> trialList = this.getTrials();
        for (Trial trial : trialList) {
            trialExecutor.submit(trial);
        }
        trialExecutor.shutdown();
    }
}
