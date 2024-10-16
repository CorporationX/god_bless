package school.faang.task317.kingdom;

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

    public void addTrial(Trial trial){
        trials.add(trial);
    }
    public void startTrial(ExecutorService executor){
        for (Trial t : trials){
            executor.submit(t);
        }
    }
}
