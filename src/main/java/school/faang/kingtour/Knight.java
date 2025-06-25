package school.faang.kingtour;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * @author Danil Pudovkin
 * @since 21.06.2025
 */
@RequiredArgsConstructor
public class Knight {

    private final String name;
    private final List<Trial> trials = new ArrayList<>();

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials(ExecutorService executor) {
        trials.forEach(executor::submit);
    }
}
