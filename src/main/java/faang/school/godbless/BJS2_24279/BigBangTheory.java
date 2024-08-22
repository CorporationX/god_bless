package faang.school.godbless.BJS2_24279;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        List<Task> taskList = new ArrayList<>(Arrays.asList(
                new Task("Sheldon", "Math problem"),
                new Task("Leonard", "Chemistry problem"),
                new Task("Govard", "Physics problem"),
                new Task("Radjesh", "Informatics problem")
        ));

        for(var task : taskList) {
            executorService.submit(task);
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks are done");
    }
}
