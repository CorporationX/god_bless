package faang.school.godbless.BJS2_1109;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@Getter
public class Knight {
    private String name;
    private List<Trial> trials = new ArrayList<>();

    public Knight(String name){
        this.name = name;
    }

    public void addTrial(Trial trial, List<Trial> trials){
        trials.add(trial);
    }

    public void startTrials(ExecutorService executorService){
        try {
            for (Trial trial : trials) {
                executorService.submit(trial);
            }
        } catch (Exception e){
            throw new RuntimeException("Exception in method startTrials");
        }

    }
}
