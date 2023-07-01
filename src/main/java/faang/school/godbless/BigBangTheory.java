package faang.school.godbless;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Task sheldonTask = new Task("Sheldon", "searching theory");
        Task leonardTask = new Task("Leonard", "modelling experiments");
        Task howardTask = new Task("Govard", "create tools");
        Task rajeshTask = new Task("Radjesh", "analyze data");

        executorService.execute(sheldonTask);
        executorService.execute(leonardTask);
        executorService.execute(howardTask);
        executorService.execute(rajeshTask);

        executorService.shutdown();
        while (!executorService.isTerminated()) {
            // waiting
        }

        System.out.println("All tasks completed");
    }
}
