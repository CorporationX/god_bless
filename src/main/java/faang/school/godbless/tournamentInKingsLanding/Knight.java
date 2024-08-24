package faang.school.godbless.tournamentInKingsLanding;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Knight {
    private final String name;
    private final List<Trial> trials;

    public Knight(String name) {
        this.name = name;
        this.trials = new ArrayList<>();
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
        trial.setKnightName(name);
    }

    public Runnable startTrails() {
        return () -> {
            for (Trial trial : trials) {
                trial.run();
            }
        };
    }
}
