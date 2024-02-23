package faang.school.godbless.tournament;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
@RequiredArgsConstructor
public class Knight {

    private final String name;
    private List<Trial> trials = new ArrayList<>();
    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials() {
        trials.forEach(trial -> executor.scheduleWithFixedDelay(trial, 0, 1, TimeUnit.SECONDS));
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
