package school.faang.bjs2_89569;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Knight {
    @Getter
    private String name;
    @Getter
    private List<Trial> trials = new ArrayList<>();
    private static final int THREAD = 4;

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        if (trial == null) {
            System.out.println("Trial cannot be null");
        }
        trials.add(trial);
    }

    public void startTrials() {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD);
        for (Trial trial : trials) {
            executor.submit(trial);
        }
        executor.shutdown();
    }
}
