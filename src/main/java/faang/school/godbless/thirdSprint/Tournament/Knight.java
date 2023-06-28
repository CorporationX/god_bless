package faang.school.godbless.thirdSprint.Tournament;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        ExecutorService service = Executors.newCachedThreadPool();
        for (Trial trial : trials) {
            service.submit(trial);
        }
        service.shutdown();
    }
}
