package faang.school.godbless.multithreading.tournament;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public record Knight(String name, List<Trial> trials) {

    public Knight(String name) {
        this(name, new ArrayList<>());
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials(ExecutorService execoturService) {
        for (Trial trial : trials) {
            execoturService.execute(trial);
        }
        while(true) {
            if (execoturService.isTerminated()) {
                System.out.println(name + "завершил проходить испытания");
                return;
            }
        }
    }
}
