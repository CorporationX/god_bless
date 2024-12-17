package school.faang.bjs247622;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Getter
@RequiredArgsConstructor
public class Knight {
    private final String name;
    private final List<Trial> trials = new ArrayList<>();


    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials(ExecutorService executorService) {
        trials.forEach(executorService::submit);
    }
}