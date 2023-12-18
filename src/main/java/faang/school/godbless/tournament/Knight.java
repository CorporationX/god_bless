package faang.school.godbless.tournament;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Data
public class Knight {
    private String name;
    private List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrials(Trial trial) {
        trials.add(trial);
    }

    public void startTrials(ExecutorService executorService) {
        try {
            for (Trial trial : trials) {
                executorService.submit(trial);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

