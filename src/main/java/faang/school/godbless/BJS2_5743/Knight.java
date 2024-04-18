package faang.school.godbless.BJS2_5743;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Knight {
    private String name;
    List<Trial> trials;

    public Knight(String name) {
        this.name = name;
        this.trials = new ArrayList<>();
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }
}
