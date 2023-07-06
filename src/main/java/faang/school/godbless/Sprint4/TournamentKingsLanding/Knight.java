package faang.school.godbless.Sprint4.TournamentKingsLanding;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Knight {
    @Getter
    private String name;
    private List<Trial> trials = new ArrayList<>();

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    Knight(String name) {
        this.name = name;
    }

    public void startTrials() {
        for (Trial trial : trials) {
            trial.run();
        }
    }
}
