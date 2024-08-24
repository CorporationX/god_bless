package faang.school.godbless.BJS2_24174;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
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
        if (executorService.awaitTermination(1, TimeUnit.MINUTES))
            System.out.println("All tasks completed.");
    }
}