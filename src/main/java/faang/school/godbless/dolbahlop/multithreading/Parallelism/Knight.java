package faang.school.godbless.dolbahlop.multithreading.Parallelism;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Getter
public class Knight {
    private String name;
    private List<Trail> trials = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trail trial) {
        trials.add(trial);
    }

    public void startTrials(ExecutorService executorService) {
        for (Trail trial : trials) {
            executorService.submit(trial);
        }
    }
}
