package module_3.module_3_1_Parallelism_Thread.tourneyAtKingsLanding_35756;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;


@Data
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
            executorService.execute(trial);
        }
    }
}
