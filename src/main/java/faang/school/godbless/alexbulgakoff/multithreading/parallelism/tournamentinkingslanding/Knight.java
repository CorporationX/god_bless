package faang.school.godbless.alexbulgakoff.multithreading.parallelism.tournamentinkingslanding;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * @author Alexander Bulgakov
 */
@Getter
@ToString
public class Knight {

    private final String name;
    private final List<Trial> trials;

    public Knight(String name) {
        this.name = name;
        trials = new ArrayList<>();
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials(ExecutorService executorService) {
        for (Trial trial : trials) {
            executorService.submit(trial);
        }
    }
}
