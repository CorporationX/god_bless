package school.faang.Tourament;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Knight {
    @Getter
    private final String name;
    private final List<Trial> trials = new ArrayList<>();
    public static final int THREAD_COUNT = 5;

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials(ExecutorService executor) {
        trials.forEach(executor::submit);
    }

    public static void main(String[] args) {
        Knight knight1 = new Knight("Richard");
        knight1.addTrial(new Trial(knight1.getName(), "Sword Fighting"));
        knight1.addTrial(new Trial(knight1.getName(), "Obstacles and Traps"));

        Knight knight2 = new Knight("Arthur");
        knight2.addTrial(new Trial(knight2.getName(), "Enchanted Forest"));
        knight2.addTrial(new Trial(knight2.getName(), "Shield Toss"));

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        knight1.startTrials(executor);
        knight2.startTrials(executor);

        executor.shutdown();

        try {
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                System.out.println("Trials were not completed after 30 seconds, closing tasks");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
        System.out.println("All trials completed");
    }
}
