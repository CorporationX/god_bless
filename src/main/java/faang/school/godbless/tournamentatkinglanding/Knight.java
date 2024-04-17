package faang.school.godbless.tournamentatkinglanding;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@AllArgsConstructor
public class Knight {
    private String name;
    private List<Trial> trials;

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrial() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (Trial trial : trials) {
            executorService.submit(trial);
        }
        executorService.shutdown();
    }
}
