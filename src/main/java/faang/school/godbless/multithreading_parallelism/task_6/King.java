package faang.school.godbless.multithreading_parallelism.task_6;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    private static final int THREAD_COUNT = 2;
    private static final ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

    public static void main(String[] args) {
        List<Knight> knights = new ArrayList<>();
        Knight firstKnight = new Knight("Bob");
        Knight secondKnight = new Knight("David");

        firstKnight.addTrial(new Trial(firstKnight.getName(), "Jousting Tournament"));
        firstKnight.addTrial(new Trial(firstKnight.getName(), "Swordsmanship Duel"));
        secondKnight.addTrial(new Trial(secondKnight.getName(), "Mounted Archery Challenge"));
        secondKnight.addTrial(new Trial(secondKnight.getName(), "Gauntlet of Strength and Endurance"));

        knights.add(firstKnight);
        knights.add(secondKnight);

        startTrials(knights);
    }

    private static void startTrials(@NonNull List<Knight> knights) {
        knights.stream()
                .flatMap(knight -> knight.getTrials().stream())
                .forEach(executor::submit);
        executor.shutdown();
    }
}
