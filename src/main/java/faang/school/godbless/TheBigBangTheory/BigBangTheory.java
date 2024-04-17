package faang.school.godbless.TheBigBangTheory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {

    private static final String[] CHARACTER_NAMES = {"Sheldon", "Leonard", "Howard", "Rajesh"};
    private static final String[] CHARACTER_TASKS = {"Prepare theory", "Experiment modeling", "Developing instruments", "Data analysis"};

    public static void main(String[] args) {
        BigBangTheory bigBangTheory = new BigBangTheory();

        bigBangTheory.MAIN();
    }

    private void MAIN() {

        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (int i = 0; i < CHARACTER_TASKS.length; i++) {
            String character = CHARACTER_NAMES[i];
            String task = CHARACTER_TASKS[i];

            executor.submit(new Task(character, task));
        }

        executor.shutdown();

        try {
            if (executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS)) {
                System.out.println("All tasks done, let's play video games!");
            } else {
                System.out.println("Timeout occurred before termination!");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Tasks interrupted: " + e.getMessage());
        }

    }
}
