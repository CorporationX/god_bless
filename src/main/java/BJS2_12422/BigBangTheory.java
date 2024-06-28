package BJS2_12422;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        Task taskS = new Task("Sheldon", "theory preparing");
        Task taskL = new Task("Leonard", "experiment modeling");
        Task taskH = new Task("Howard", "tools developing");
        Task taskR = new Task("Rajesh", "data analysis");

        ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.submit(taskS);
        executor.submit(taskL);
        executor.submit(taskH);
        executor.submit(taskR);

        executor.shutdown();
    }
}
