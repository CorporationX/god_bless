package faang.school.godbless.tournir;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Knight implements Runnable {
    private String name;
    private List<Trial> trials;

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        if (trials == null) {
            trials = new ArrayList<>();
        }

        trials.add(trial);
    }

    @Override
    public void run() {
        for (Trial trial : trials) {
            trial.run();
        }
    }
}
