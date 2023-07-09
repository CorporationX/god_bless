package faang.school.godbless.Multithreading.ParallelismAndThread.task09_TournamentInKingsLanding;

import lombok.Data;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
@Data
public class Knight {
    private String name;
    private List<Trial> trials;
    public Knight(String name) {
        this.name = name;
    }
    public void addTrial(Trial trial){
        trials.add(trial);
    }

    public void startTrials() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(trials.size());

        for (Trial trial : trials) {
            executorService.submit(trial);
        }
        executorService.shutdown();
        if (executorService.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println("Successful");
        } else {
            System.out.println("Error");
        }
    }

}
