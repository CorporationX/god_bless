package kingslay.tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@AllArgsConstructor
public class Knight {
    @NonNull
    @Getter
    private final String name;
    private final List<Trial> trials = new ArrayList<>();

    public void addTrial(@NonNull Trial trial) {
        trials.add(trial);
    }

    public void startTrails(@NonNull ExecutorService executor) {
        trials.forEach(executor::submit);
    }
}
