package school.faang.multithreading.parallelism.tournament;

import lombok.Getter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Getter
public class Knight {
    private String name;
    private List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(String trialName) {
        trials.add(new Trial(this.name, trialName));
    }

    @SneakyThrows
    public void startTrials() {
        int threadPoolSize = trials.size();
        ExecutorService executor = Executors.newFixedThreadPool(threadPoolSize);
        trials.forEach(executor::submit);
        executor.shutdown();
        if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
            executor.shutdownNow();
        }
    }
}
