package school.faang.BJS2_35771_KingTournament;

import lombok.Getter;
import lombok.SneakyThrows;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Getter
public class Knight {
    private static final int TERMINATION_WAIT_SECONDS = 15;

    private String name;
    private List<Trial> trials;

    public Knight(String name) {
        this.name = name;
        trials = new ArrayList<>();
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    @SneakyThrows
    public boolean startTrials() {
        int trialsCount = trials.size();
        ExecutorService service = Executors.newFixedThreadPool(trialsCount);
        trials.forEach(service::submit);
        service.shutdown();
        if (!service.awaitTermination(TERMINATION_WAIT_SECONDS, TimeUnit.SECONDS)) {
            service.shutdownNow();
            return false;
        } else {
            return true;
        }
    }
}
