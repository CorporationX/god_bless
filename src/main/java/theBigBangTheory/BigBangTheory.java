package theBigBangTheory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        Task taskForSheldon = new Task("Sheldon", "Theory preparation");
        Task taskForLeonard = new Task("Leonard", "Experiment simulation");
        Task taskForHoward = new Task("Howard", "Tool development");
        Task taskForRajesh = new Task("Rajesh", "Data analysis");
        List<Task> tasks = List.of(taskForSheldon, taskForLeonard, taskForHoward, taskForRajesh);

        for (int i = 0; i < 4; i++) {
            int j = i;
            executor.submit(() -> tasks.get(j).run());
        }

        executor.close();
        System.out.println("All tasks is completed");
    }
}
