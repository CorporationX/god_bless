package faang.school.godbless.thread.tournament;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Knight {
    private String name;
    private List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public Runnable startTrials() {
        return () -> trials.forEach(Trial::run);
    }
}
