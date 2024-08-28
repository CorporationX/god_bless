package faang.school.godbless.BJS2_23525;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static void main(String[] args) {
        var whiteKnight = new Knight("White");
        var darkKnight = new Knight("Dark");
        var trialsForKnights = new ArrayList<>(
                List.of(
                        new Trial("White", "Duel with the Shadow"),
                        new Trial("White", "Labyrinth of Wisdom"),
                        new Trial("Dark", "Test of Compassion"),
                        new Trial("Dark", "Bridge of Courage"),
                        new Trial("Dark", "Ring of Fire"),
                        new Trial("White", "Chalice of Truth"),
                        new Trial("Dark", "Test of Generosity"),
                        new Trial("White", "Castle Defense")
                )
        );
        trialsForKnights.stream()
                .filter(trial -> trial.getKnightName().equals("White"))
                .forEach(whiteKnight::addTrial);
        trialsForKnights.stream()
                .filter(trial -> trial.getKnightName().equals("Dark"))
                .forEach(darkKnight::addTrial);


        var executorService = Executors.newFixedThreadPool(6);

        whiteKnight.startTrials(executorService);
        darkKnight.startTrials(executorService);

        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
