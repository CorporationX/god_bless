package faang.school.godbless.BJS2_10959;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Knight {
    private String name;
    private List<Trial> trials;
    private Map<String, String> trialsMap = new HashMap<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        if (trials == null) {
            trials = new ArrayList<>();
        }
        trials.add(trial);
    }

    public void startTrials() {
        trials.forEach(Trial::run);
    }
}
