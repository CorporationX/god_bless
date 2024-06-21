package faang.school.godbless.kingstournament;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        ExecutorService service = Executors.newFixedThreadPool(trials.size());

        try {
            for (Trial trial : trials) {
                service.submit(trial);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        service.shutdown();
    }
}
