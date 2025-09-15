package school.faang.bjs2_89555;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Task taskOne = new Task("Sheldon", "theory preparation");
        Task taskTwo = new Task("Leonard", "simulation of experiment");
        Task taskThree = new Task("Howard", "tool development");
        Task taskFour = new Task("Rajesh", "data analysis");
        List<Task> tasks = List.of(taskOne, taskTwo, taskThree, taskFour);

        for (int i = 0; i < 4; i++) {
            executor.submit(tasks.get(i));
        }
        executor.shutdown();
    }
}
