package faang.school.godbless.bjs2_5455;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
public class Knight {

    private String name;
    private List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        log.info("Add trial {} for knight: {}", trial.getTrialName(), trial.getKnightName());
        trials.add(trial);
    }
}
