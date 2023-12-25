package faang.school.godbless.multithreading_parallelism.the_big_bang_theory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        String[] names = new String[]{"Sheldon", "Leonard", "Govard", "Radzhesh"};
        String[] tasks = new String[]{"theory preparation", "simulation of experiment", "tool development", "data analysis"};

        for (int i = 0; i < 4; i++) {
            executorService.execute(new Task(names[i], tasks[i]));
        }

        executorService.shutdown();

    }
}
