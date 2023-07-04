package faang.school.godbless.TBBT;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        List<Task> tasks = List.of(new Task("Sheldon", "Making theory"),
                new Task("Leonard", "Modeling experiment"),
                new Task("Howard", "Making instruments"),
                new Task("Rajesh", "Data analysis"));

        ExecutorService taskManager = Executors.newFixedThreadPool(4);
        tasks.forEach(taskManager::submit);
        taskManager.shutdown();
        if (taskManager.awaitTermination(60, TimeUnit.SECONDS)) {
            System.out.println("Все задания выполнены!");
        }
    }
}
