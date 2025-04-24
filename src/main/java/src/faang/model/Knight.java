package src.faang.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RequiredArgsConstructor
public class Knight {
    @Getter
    private final String name;
    private final List<Trial> trials = new ArrayList<>();

    public void add(Trial trial) {
        trials.add(trial);
    }

    public void startsTrial() {
        final ExecutorService executor = Executors.newFixedThreadPool(trials.size());

        for (Trial trial : trials) {
            executor.execute(trial);
        }
    }
}
