package faang.school.godbless.multithreading.king_landing;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Knight {
    private String name;
    private List<Trial> trials;

    public Knight(String name) {
        this.name = name;
        trials = new ArrayList<>();
    }

    public void addTrial(Trial trial) {
        if (!trial.getKnightName().equalsIgnoreCase(name)) {
            System.out.println("The trial is not for this knight");
            return;
        }
        trials.add(trial);
    }

    public void startTrials(){
        ExecutorService service = Executors.newCachedThreadPool();
        trials.forEach(service::execute);
        service.shutdown();
        try {
            if (!service.awaitTermination(10, TimeUnit.SECONDS)){
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
