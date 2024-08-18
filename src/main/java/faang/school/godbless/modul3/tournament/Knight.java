package faang.school.godbless.modul3.tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Knight {
    private final String name;
    private final List<Trial> trials;

    public synchronized void startTrials() {
        trials.forEach(Trial::run);
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }
}
