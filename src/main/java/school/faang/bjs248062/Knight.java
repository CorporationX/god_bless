package school.faang.bjs248062;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class Knight {

    @Getter
    private String name;
    private List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials(ExecutorService service) {
        for (Trial trial : trials) {
            service.submit(trial);
        }
    }

}
