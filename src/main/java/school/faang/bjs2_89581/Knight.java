package school.faang.bjs2_89581;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Setter
@Getter
public class Knight {

    private String name;
    private List<Trial> trials = new ArrayList<>();

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials(ExecutorService exec) {
        for (Trial t : trials) {
            exec.submit(t);
        }
    }

    public Knight(String name) {
        this.name = name;
    }
}
