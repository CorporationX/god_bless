package thread.six;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Setter
@Getter
public class Knight {

    private String name;
    private List<Trial> trials;

    public Knight(String name) {
        this.name = name;
        this.trials = new ArrayList<>();
    }

    public void addTrial(@NonNull Trial trial) {
        trials.add(trial);
    }

    public void startTrials(ExecutorService executor) {

        if (trials == null || trials.isEmpty()) {
            throw new IllegalArgumentException("trials is null or empty");
        }

        trials.forEach(executor::execute);
    }
}
