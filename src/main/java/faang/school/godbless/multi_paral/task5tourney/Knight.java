package faang.school.godbless.multi_paral.task5tourney;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Data
public class Knight {
    private String name;
    private int countWin;
    private List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials(ExecutorService executorService){
        for (Trial trial: trials) {
            executorService.submit(trial);
        }
    }
}
