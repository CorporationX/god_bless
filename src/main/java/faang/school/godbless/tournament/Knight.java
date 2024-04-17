package faang.school.godbless.tournament;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@Getter
public class Knight {
    private String name;
    private List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (Trial trial : trials) {
            executor.submit(trial);
        }
        executor.shutdown();

        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)){
                log.error("The trial was not completed");
                return;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("All trials were completed by " + name);
    }
}
