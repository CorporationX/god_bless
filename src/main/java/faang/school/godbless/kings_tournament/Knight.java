package faang.school.godbless.kings_tournament;

import lombok.Getter;
import lombok.NonNull;

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

    public void addTrial(@NonNull Trial trial) {
        trials.add(trial);
    }

    public void startTrails() {
        trials.forEach(Trial::run);
    }
}
