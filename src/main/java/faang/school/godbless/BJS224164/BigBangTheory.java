package faang.school.godbless.BJS224164;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        Task theory = new Task("Sheldon", "preparation of theory");
        Task experiment = new Task("Leonard", "simulation of experiment");
        Task tools = new Task("Govard", "development of tools");
        Task data = new Task("Rajesh", "data analysis");

        executor.submit(theory);
        executor.submit(experiment);
        executor.submit(tools);
        executor.submit(data);

        executor.shutdown();

        while (!executor.isTerminated()) {
        }
        System.out.println("All tasks were done.");
    }
}

