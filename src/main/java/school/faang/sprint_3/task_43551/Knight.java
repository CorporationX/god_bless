package school.faang.sprint_3.task_43551;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Data
@AllArgsConstructor
public class Knight {
    private String name;
    private final List<Trial> trials = new ArrayList<>();

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials(ExecutorService executor) {
        for (Trial trial : trials) {
            executor.submit(trial);
        }
    }
}
