package school.faang.kingstournament;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public record Knight(String name, List<Trial> trials) {
    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials() {
        ExecutorService service = Executors.newFixedThreadPool(trials.size());
        for (Trial trial : trials) {
            service.submit(trial);
        }
        service.shutdown();
    }
}
