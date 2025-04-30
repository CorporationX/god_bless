package school.faang.big_bang_theory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Task firstTask = new Task("Sheldon ", "theory preparation");
        Task secondTask = new Task("Leonard ", "experiment modeling");
        Task thirdTask = new Task("Howard ", "tool development");
        Task fourthTask = new Task("Rajesh ", "data analysis");
        executor.execute(firstTask);
        executor.execute(secondTask);
        executor.execute(thirdTask);
        executor.execute(fourthTask);

        executor.shutdown();

        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
            System.out.println("Все задачи завершены");
        } catch (InterruptedException e) {
            executor.shutdownNow();
            System.out.println("Программа была прервана");
        }
    }
}
