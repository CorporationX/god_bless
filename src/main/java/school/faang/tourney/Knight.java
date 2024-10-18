package school.faang.tourney;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Getter
public class Knight {
    private String name;
    List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials(ExecutorService executorService) {
        for (Trial trial : trials) {
            executorService.execute(trial);
        }
    }
}
