package faang.school.godbless.kingHarbor;

import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Data
public class Knight {
    @NonNull
    private String name;
    private List<Trial> trials = new ArrayList<>();

    public void addTrial(Trial trial){
        trials.add(trial);
    }
    public void startTrials(){
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (var trial : trials){
            service.submit(trial);
        }
        service.shutdown();
    }
}
