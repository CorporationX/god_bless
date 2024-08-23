package faang.school.godbless.BJS223647;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
@Setter
public class Knight {
    private String name;
    private List<Trial> trials;

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public Knight(String name) {
        this.name = name;
        this.trials = new ArrayList<>();
    }

    public void startTrials() {
        int threadPool = 2;
        ExecutorService executorService = Executors.newFixedThreadPool(threadPool);
        for (Trial trial : trials) {
            new Thread(trial).start();
        }
        executorService.shutdown();
    }
}
