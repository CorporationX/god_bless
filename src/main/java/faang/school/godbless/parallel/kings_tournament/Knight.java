package faang.school.godbless.parallel.kings_tournament;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Knight {
    private List<Trial> trials = new ArrayList<>();
    private String name;

    public Knight(String name) {
        this.name = name;
    }

    public List<Trial> getTrials() {
        return trials;
    }

    public String getName() {
        return name;
    }
    public void addTrial(Trial trial) {
        trials.add(trial);
    }
    public void startTrials() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(trials.size());
        for (Trial trial : trials) {
            System.out.printf("Испытание для рыцаря %s началось!\n", this.getName());
            executorService.submit(trial);
        }
        executorService.awaitTermination(2, TimeUnit.SECONDS);
        executorService.shutdown();
        System.out.printf("Испытание для рыцаря %s завершено!\n", name);
    }
}


