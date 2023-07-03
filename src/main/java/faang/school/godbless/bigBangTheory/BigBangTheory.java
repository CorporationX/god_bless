package faang.school.godbless.bigBangTheory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Task sheldonTask = new Task("Sheldon", "prepare theory");
        Task leonardTask = new Task("Leonard", "simulate experiment");
        Task howardTask = new Task("Howard", "developing tools");
        Task rajeshTask = new Task("Rajesh", "data analysis");

        executorService.execute(sheldonTask);
        executorService.execute(leonardTask);
        executorService.execute(howardTask);
        executorService.execute(rajeshTask);

        executorService.shutdown();

        while (!executorService.isTerminated()) {

        }

        System.out.println("All tasks are completed");
    }
}
