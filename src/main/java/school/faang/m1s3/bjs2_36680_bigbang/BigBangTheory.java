package school.faang.m1s3.bjs2_36680_bigbang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>(Arrays.asList(
                new Task("Sheldon", "Theoretical preparation"),
                new Task("Leonard", "Modelling of experiment"),
                new Task("Howard", "Equipment development"),
                new Task("Rajesh Ramayan Koothrappali", "Data analysis, Holy Cow!")
        ));

        ExecutorService executorService = Executors.newFixedThreadPool(tasks.size());

        tasks.forEach(executorService::execute);

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
                System.out.println("Experiment failed!");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Experiment has ended!");
    }
}
