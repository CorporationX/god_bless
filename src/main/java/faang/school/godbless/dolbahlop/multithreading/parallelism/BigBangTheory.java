package faang.school.godbless.dolbahlop.multithreading.parallelism;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        String[] names = {"Sheldon", "Leonard", "Howard", "Rajesh"};
        String[] tasks = {"Theory preparation", "Simulation of experiment", "Tool development", "Data analysis"};
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 4; i++) {
            executor.execute(new Task(names[i], tasks[i]));
        }
        executor.shutdown();
    }
}
