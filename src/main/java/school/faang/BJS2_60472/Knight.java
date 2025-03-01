package school.faang.BJS2_60472;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@RequiredArgsConstructor
@Getter
public class Knight {
    private final String name;
    private List<Trial> trials = new ArrayList<>();

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials(ExecutorService executorService) {
        if (trials.isEmpty()) {
            throw new IllegalArgumentException("ведите испытание");
        }
        for (Trial trial : trials) {
            executorService.submit(trial);
        }
    }
}