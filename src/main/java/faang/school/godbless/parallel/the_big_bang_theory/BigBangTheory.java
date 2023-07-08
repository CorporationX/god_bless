package faang.school.godbless.parallel.the_big_bang_theory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(4);
        Task firstTask = new Task("Sheldon", "preparation of the theory");
        Task secondTask = new Task("Leonard", "simulation of the experiment");
        Task thirdTask = new Task("Howard", "tool development");
        Task fourthTask = new Task("Rajesh", "data analysis");
        executor.execute(firstTask);
        executor.execute(secondTask);
        executor.execute(thirdTask);
        executor.execute(fourthTask);
        executor.shutdown();

        executor.awaitTermination(5000, TimeUnit.MILLISECONDS);

        System.out.println("Все задачи выполнены");


    }
}
