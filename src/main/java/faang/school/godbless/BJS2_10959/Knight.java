package faang.school.godbless.BJS2_10959;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Getter
public class Knight {
    private String name;
    private List<Trial> trials;
    private Map<String, String> trialsMap = new HashMap<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        if (trials == null) {
            trials = new ArrayList<>();
        }
        trial.setKnightName(this.getName());
        trials.add(trial);
    }

    public void startTrials() {
        ExecutorService service = Executors.newFixedThreadPool(2);
        trials.forEach(Trial::run);
        service.shutdown();
        try {
            service.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
    }

}
