package faang.school.godbless.bbt;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        List.of(
                new Task("Sheldon", "Prepare Theory"),
                new Task("Leonard", "Experiment Model"),
                new Task("Howard", "Equipment Preparation"),
                new Task("Rajesh", "Data Analysis")
        ).forEach(executor::submit);
        executor.shutdown();
        try {
            while(!executor.awaitTermination(4, TimeUnit.SECONDS)) {
                System.out.println("Tasks in progress...");
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("=============================");
        System.out.println("All tasks have been finished!");
    }
}
