package Sprint_3.BJS2_35781;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
public class Knight {
    private String name;
    private List<Trial> trials;

    public Knight(String name) {
        this.name = name;
        this.trials = new ArrayList<>();
    }


    public void addTrial(Trial trial) {
        this.trials.add(trial);
    }

    public void startTrials() {

        ExecutorService executorService = Executors.newFixedThreadPool(trials.size());
        for (Trial trial : trials) {
            executorService.submit(() -> {
                System.out.println("Рыцарь: " + name + " Закончил испытание : " + trial.getTrialName());
                trial.run();
                System.out.println("Рыцарь: " + name + " Закончил испытание " + trial.getTrialName());
            });
        }
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();

            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }

}
