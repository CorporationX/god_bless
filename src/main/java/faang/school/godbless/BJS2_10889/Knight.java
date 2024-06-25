package faang.school.godbless.BJS2_10889;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Knight {
    private final String name;
    private final List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }
}
