package faang.school.godbless.tournament;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Getter
@Setter
@ToString
public class Knight {
    private final String name;
    private List<Trial> trials;

    public Knight(String name) {
        this.name = name;
        this.trials = new ArrayList<>();
    }

    public void addTrial(Trial trial) {
        if (trial != null) {
            this.trials.add(trial);
        }
    }

    public void startTrials(ExecutorService executorService) {
        trials.forEach(executorService::execute);
    }
}
