package faang.school.godbless.ThirdSprint.BJS2_23533;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class Knight {
    @NonNull
    private String name;
    private List<Trial> trials = new ArrayList<>();

    public void addTrial(Trial trial) {
        trials.add(new Trial(trial.getTrialName(), name));
    }

    public void startTrials() {
        this.trials.stream().forEach(t -> King.service.submit(t));
    }
}
