package faang.school.godbless.BJS2_11197;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
public class Knight {
    private String name;
    private List<Trial> trials;

    public Knight(String name) {
        this.name = name;
        trials = new ArrayList<>();
    }

    public void addTrial(Trial trial) {
        if (trial != null) {
            trials.add(trial);
        }
    }

    void startTrials() {
        trials.stream().forEach(Trial::run);
    }
}
