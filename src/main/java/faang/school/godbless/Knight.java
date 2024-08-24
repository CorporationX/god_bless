package faang.school.godbless;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Data
@RequiredArgsConstructor
public class Knight {
    private final String name;

    private List<Trial> trials = new ArrayList<>();
    private ExecutorService executorService;


    public void addTrial(Trial trial){
        trials.add(trial);
    }

    public void startTrials() {
        for (Trial trial : trials) {
            if(executorService!=null) {
                executorService.submit(trial);
            }
        }
    }


}
