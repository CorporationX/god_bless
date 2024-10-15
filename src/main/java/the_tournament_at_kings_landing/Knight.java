package the_tournament_at_kings_landing;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Knight {
    private String name;
    private final List<Trial> trials = new ArrayList<>();

    /**
     * Adds a trial to this knight's list of trials.
     *
     * @param trial The trial to add.
     */
    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    /**
     * Runs all of this knight's trials.
     *
     * <p>This method calls {@link Trial#run()} on each trial, catching any
     * {@link InterruptedException}s that may be thrown and rethrowing them as
     * unchecked {@link IllegalArgumentException}s.
     */
    public void startTrials() {
        trials.forEach(trial -> {
            try {;
                trial.run();
            } catch (InterruptedException e) {
                throw new IllegalArgumentException(e);
            }
        });
    }
}
