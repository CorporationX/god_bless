package faang.school.godbless.multithreading.tournament;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class Knight {

    @Getter
    private final String name;
    private final List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        if (trial == null) {
            throw new IllegalArgumentException("> no trials were found");
        }

        trials.add(trial);
    }


    public void startTrials(ExecutorService service) {
        this.trials.forEach(service::submit);
    }

}
