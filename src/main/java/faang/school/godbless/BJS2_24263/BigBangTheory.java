package faang.school.godbless.BJS2_24263;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        String[] names = {"Sheldon", "Leonard", "Howard", "Rajesh"};
        String[] tasks = {"Theory preparation", "Simulation of experiment", "Tool development", "Data analysis"};
        int poolSize = 4;
        ExecutorService executorService = Executors.newFixedThreadPool(poolSize);
        for (int i = 0; i < poolSize; i++) {
            executorService.execute(new Task(names[i], tasks[i]));
        }
        executorService.shutdown();
    }
}
