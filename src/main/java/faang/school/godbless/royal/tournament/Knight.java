package faang.school.godbless.royal.tournament;

import static faang.school.godbless.royal.tournament.King.TIME_FOR_WHOLE_TOURNAMENT_IN_SECONDS;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Getter
public class Knight {
    private final String name;
    private final List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        trial.setKnightName(name);
        trials.add(trial);
    }

    public void startTrials() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        trials.forEach(executorService::submit);
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(TIME_FOR_WHOLE_TOURNAMENT_IN_SECONDS, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException exception) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
