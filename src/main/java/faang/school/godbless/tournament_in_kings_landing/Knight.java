package faang.school.godbless.tournament_in_kings_landing;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Knight {
    @Getter
    private String name;
    @Getter
    List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrials(Trial trial) {
        trials.add(trial);
    }

    public void startTrials() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for(Trial trial : trials) {
            executor.submit(trial);
        }
        executor.shutdown();
    }
}
