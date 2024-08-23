package faang.school.godbless.the_big_bang_theory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService poolThreads = Executors.newFixedThreadPool(4);

        Task sheldonTask = new Task("Sheldon", "Prepare theory");
        Task leoTask = new Task("Leo", "Modeling experiment");
        Task govardTask = new Task("Govard", "Tool development");
        Task radTask = new Task("Radjesh", "Analysis date");

        poolThreads.execute(sheldonTask);
        poolThreads.execute(leoTask);
        poolThreads.execute(govardTask);
        poolThreads.execute(radTask);

        poolThreads.shutdown();
    }
}
