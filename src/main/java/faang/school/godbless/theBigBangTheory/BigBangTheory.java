package faang.school.godbless.theBigBangTheory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Task sheldon = new Task("Sheldon","Theory preparation");
        Task leonard = new Task("Leonard","Experiment modulation");
        Task howard = new Task("Howard","Instruments development");
        Task rajesh = new Task("Rajesh","Data analyzing");

        executor.submit(sheldon);
        executor.submit(leonard);
        executor.submit(howard);
        executor.submit(rajesh);
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
            System.out.println("All tasks are done!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
