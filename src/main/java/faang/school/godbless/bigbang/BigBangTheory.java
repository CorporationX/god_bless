package faang.school.godbless.bigbang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Task task1 = new Task("Sheldon", "Preparing of theory");
        Task task2 = new Task("Leonard", "Simulation of experiment");
        Task task3 = new Task("Govard", "Developing of instruments");
        Task task4 = new Task("Radjesh", "Analyzing of data");
        executorService.execute(task1);
        executorService.execute(task2);
        executorService.execute(task3);
        executorService.execute(task4);
        executorService.shutdown();
    }
}
