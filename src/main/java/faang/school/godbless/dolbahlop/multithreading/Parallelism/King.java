package faang.school.godbless.dolbahlop.multithreading.Parallelism;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight arthur = new Knight("Arthur");
        Knight marmont = new Knight("Marmont");
        arthur.addTrial(new Trail(arthur.getName(), "Trail 1"));
        arthur.addTrial(new Trail(arthur.getName(), "Trail 2"));
        marmont.addTrial(new Trail(marmont.getName(), "Trail 3"));
        marmont.addTrial(new Trail(marmont.getName(), "Trail 4"));
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        arthur.startTrials(executorService);
        marmont.startTrials(executorService);
        executorService.shutdown();
    }
}
