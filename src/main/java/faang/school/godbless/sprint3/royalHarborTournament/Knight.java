package faang.school.godbless.sprint3.royalHarborTournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.concurrent.ExecutorService;

@Getter
@AllArgsConstructor
public class Knight {

    private String name;
    private List<Trial> trials;

    public Knight addTrial(Trial trial) {
        trials.add(trial);
        return this;
    }

    public void startTrials(ExecutorService executorService) {
        trials.forEach(executorService::submit);
    }
}
