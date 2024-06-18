package faang.school.godbless.tournament;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class Knight {
    private final String name;
    private final List<Trial> trials = new ArrayList<>();

    public void addTrial(@NonNull Trial trial) {
        trials.add(trial);
    }

    public void startTrials() {
        for (Trial trial : trials) {
            trial.run();
        }
    }
}
