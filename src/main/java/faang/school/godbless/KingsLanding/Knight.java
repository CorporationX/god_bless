package faang.school.godbless.KingsLanding;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Data
public class Knight {
    private String name;
    private List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials(){
        int numThreads = trials.size();
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
        try {
            for (Trial trial: trials) {
                executorService.submit(trial::run);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

       executorService.shutdown();
    }

}
