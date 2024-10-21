package school.faang.tournamentkinglanding;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
@RequiredArgsConstructor
public class Knight {
    private final String name;
    private final List<Trial> trials = new ArrayList<>();

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        try {
            trials.stream().map(executorService::submit).forEach(future -> {
                try {
                    future.get();
                } catch (Exception e) {
                    System.err.println("Error during trial execution: " + e.getMessage());
                }
            });
        } finally {
            executorService.shutdown();
        }
    }
}

