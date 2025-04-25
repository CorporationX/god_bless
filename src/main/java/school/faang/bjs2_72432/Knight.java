package school.faang.bjs2_72432;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Getter
@RequiredArgsConstructor
public class Knight {
    private final String name;
    private List<Trial> trials = new ArrayList<>();

    public boolean addTrial(Trial trial) {
        return trials.add(trial);
    }

    public void startTrials(ExecutorService executorService) {
        trials.forEach(executorService::execute);
    }
}