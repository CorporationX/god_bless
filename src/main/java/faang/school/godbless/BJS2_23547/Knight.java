package faang.school.godbless.BJS2_23547;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@AllArgsConstructor
@Getter
public class Knight implements Runnable {
    private String name;
    private List<Trial> trialsList = new ArrayList<>();

    Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        trialsList.add(trial);
    }

    public void startTrials() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(var trial : trialsList) {
            executorService.submit(trial);
        }

        executorService.shutdown();
    }

    @Override
    public void run() {
        startTrials();
    }
}
