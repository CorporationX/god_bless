package faang.school.godbless.the_big_bang_theory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Task> tasks =
                List.of(new Task("Sheldon", "Theory preparation"),
                        new Task("Leonard", "Experiment modeling"),
                        new Task("Howard", "Developing tools"),
                        new Task("Rajesh", "Data analysis"));

        for (Task task : tasks) {
            executorService.submit(task);
        }

        executorService.shutdown();
    }
}
