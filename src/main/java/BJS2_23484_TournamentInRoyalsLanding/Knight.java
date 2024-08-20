package BJS2_23484_TournamentInRoyalsLanding;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Getter
public class Knight {
    private final String name;
    private final List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        if (trial != null) {
            getTrials().add(trial);
        }
    }

    public void startTrials(ExecutorService executor) {
        for (Trial trial : trials) {
            executor.submit(trial);
        }
    }
}
