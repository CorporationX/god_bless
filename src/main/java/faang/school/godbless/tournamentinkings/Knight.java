package faang.school.godbless.tournamentinkings;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class Knight {
    private final String name;
    private List<Trial> trials = new ArrayList<>();

    public void addTrial(Trial trial) {
        this.trials.add(trial);
        List<Trial> trials1 = this.trials;
        trials1.add(trial);
        this.trials = trials1;
    }
}

