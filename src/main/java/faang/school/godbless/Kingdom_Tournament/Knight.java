package faang.school.godbless.Kingdom_Tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@AllArgsConstructor
@Setter
@Getter
public class Knight {
    private String name;
    private List<Trial> trials;

    public Knight(String name) {
        this.name = name;
        this.trials = new ArrayList<>();
    }
    public void addTrial(Trial trial) {
        trials.add(trial);
    }
    public void startTrials() {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for(Trial trial : trials) {
            executor.submit(trial);
        }
        executor.shutdown();
    }
}
