package faang.school.godbless.BJS2_23493;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RequiredArgsConstructor
@Getter
public class Knight {

    private final String name;
    private final List<Trial> trials = new ArrayList<>();

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (Trial trial : trials) {
            executorService.submit(trial);
        }
        executorService.shutdown();
    }

}
