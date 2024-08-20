package faang.school.godbless.BJS2_23480;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Setter
@Getter
@ToString
public class Knight {
    private String name;
    private List<Trial> trialList = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }
    public void addTrial(Trial trial) {
        trialList.add(trial);
    }
    public void startTrials() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (Trial trial : trialList) {
            executorService.submit(trial);
        }
        executorService.shutdown();
    }
}
