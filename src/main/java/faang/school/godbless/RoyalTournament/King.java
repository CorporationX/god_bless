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
        secondKnight.addTrial(new Trial("Artorios", "Armwrestling"));
        firstKnight.addTrial(new Trial("Eserius", "Spear throwing"));
        secondKnight.addTrial(new Trial("Artorios", "Fire show"));
        firstKnight.addTrial(new Trial("Eserius", "Lion fight"));

        startAllTrials(List.of(firstKnight, secondKnight));
    }

    private static void startAllTrials(List<Knight> knights) {
        ExecutorService pool = Executors.newFixedThreadPool(knights.size());
        knights.forEach(knight -> pool.execute(knight::startAllTrials));
        pool.shutdown();
    }
}
