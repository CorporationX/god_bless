package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class Knight {
    String name;
    List<Trial> trials;

    public Knight(String name) {
        this.name = name;
        this.trials = new ArrayList<>();
    }

    public void addTrial(String trial) {
        trials.add(new Trial(name, trial));
    }
}
