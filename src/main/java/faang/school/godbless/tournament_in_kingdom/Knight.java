package faang.school.godbless.tournament_in_kingdom;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Knight {
    protected List<Trial> trials = new ArrayList<>();
    private final String name;


    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials() {
        for (Trial trial : trials) {
            King.poolThreads.execute(trial);
            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
