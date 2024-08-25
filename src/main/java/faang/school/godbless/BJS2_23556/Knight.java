package faang.school.godbless.BJS2_23556;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Getter
public class Knight {

    private String name;
    private List<Trial> trials;

    public Knight(String name) {
        this.name = name;
        this.trials = new ArrayList<>();
    }

    public void addTrial(Trial trial){
        trials.add(trial);
    }

    public void startTrial(ExecutorService executorService){
        for (Trial trial : trials){
            executorService.submit(trial);
        }
    }
}
