package faang.school.godbless.kxnvg.kingslanding;

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
        trial.setKnightName(name);
        trials.add(trial);
    }

    public List<Trial> startTrials() {
        return new ArrayList<>(trials);
    }
}
