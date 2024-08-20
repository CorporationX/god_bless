package faang.school.godbless.task.multithreading.royal.tournament;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Getter
public class Knight {
    private final String name;
    private final List<Trial> trials;

    public Knight(String name) {
        this.name = name;
        this.trials = new ArrayList<>();
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        IntStream.range(0, trials.size())
                .forEach(i -> executorService.submit(trials.get(i)));
        executorService.shutdown();
    }
}
