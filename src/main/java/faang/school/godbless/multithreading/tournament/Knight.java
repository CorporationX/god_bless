package faang.school.godbless.multithreading.tournament;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import lombok.Getter;

@Getter
public class Knight {
    private final String name;
    private final List<Trial> trials;

    public Knight(String name) {
        this.name = name;
        trials = new ArrayList<>();
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        trials.forEach(executorService::submit);
        executorService.shutdown();

        try {
            if (executorService.awaitTermination(2, TimeUnit.SECONDS)) {
                System.out.println(name + " выполнил все испытания");
            } else {
                System.out.println(name + " не выполнил свои испытания");
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
