package school.faang.kingstourney;

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
        if (trial == null) {
            throw new IllegalArgumentException("Trial is required");
        }
        trials.add(trial);
    }
}
