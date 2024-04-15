package faang.school.godbless.RoyalTournament;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight firstKnight = new Knight("Artorios");
        Knight secondKnight = new Knight("Eserius");
        secondKnight.addTrial(new Trial("Artorios", "Sword fight"));
        firstKnight.addTrial(new Trial("Eserius", "Horse fight"));

        startAllTrials(List.of(firstKnight, secondKnight));
    }

    private static void startAllTrials(List<Knight> knights) {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        knights.stream()
                .flatMap(knight -> knight.getTrials().stream())
                .forEach(pool::submit);
        pool.shutdown();
    }
}
