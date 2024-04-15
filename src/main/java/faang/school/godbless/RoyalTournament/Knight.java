package faang.school.godbless.RoyalTournament;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Knight {
    private String name;
    private List<Trial> trials;

    public Knight(String name) {
        this.name = name;
        this.trials = new ArrayList<>();
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }
}
