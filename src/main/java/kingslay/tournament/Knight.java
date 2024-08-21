package kingslay.tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@AllArgsConstructor
public class Knight {
    @NonNull
    @Getter
    private final String name;
    private final List<Trial> trials = new ArrayList<>();

    public void addTrial(@NonNull Trial trial) {
        trials.add(trial);
    }

    public void startTrails() {
        try(ExecutorService executor = Executors.newFixedThreadPool(3)) {
            trials.forEach(executor::execute);
            executor.shutdown();
        }
    }
}
