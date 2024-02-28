package faang.school.godbless.BJS2_3189;

import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Data
public class Knight {
    @NonNull
    private String name;
    private List<Trial> trials = new ArrayList<>();

    public void addTrial(Trial trial){
        trial.setKnightName(name);
        trials.add(trial);
    }

    public void startTrials(ExecutorService executorService){
        trials.forEach(executorService::submit);
    }
}
