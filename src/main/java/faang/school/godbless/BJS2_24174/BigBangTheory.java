package faang.school.godbless.BJS2_24174;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        var executorService = Executors.newFixedThreadPool(4);
        var taskList = new ArrayList<>(
                List.of(
                        new Task("Sheldon", "preparation of theory."),
                        new Task("Leonard", "simulation of experiment"),
                        new Task("Howard", "development of tools"),
                        new Task("Rajesh", "data analysis.")
                )
        );

        taskList.forEach(executorService::execute);
        executorService.shutdown();

        try {
            if (executorService.awaitTermination(10, TimeUnit.SECONDS))
                System.out.println("All tasks completed.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
