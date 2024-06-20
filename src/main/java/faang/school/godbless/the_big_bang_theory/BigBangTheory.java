package faang.school.godbless.the_big_bang_theory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        Task sheldonTask = new Task("Sheldon", "Theory preparation");
        Task leonardTask = new Task("Leonard", "Simulation of experiment");
        Task howardTask = new Task("Howard", "Tool development");
        Task radgeshTask = new Task("Radgesh", "Data analysis");

        executor.submit(sheldonTask);
        executor.submit(leonardTask);
        executor.submit(howardTask);
        executor.submit(radgeshTask);
        executor.shutdown();
    }
}
