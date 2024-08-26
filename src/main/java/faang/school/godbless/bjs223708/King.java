package faang.school.godbless.bjs223708;

import java.util.List;

public class King {
    public static void main(String[] args) {
        List<Trial> trials = List.of(
                new Trial("Jaime Lannister", "Trial of the Swordsmanship"),
                new Trial("Jaime Lannister", "Trial of the Shield"),
                new Trial("Brienne of Tarth", "Trial of the Maze"),
                new Trial("Brienne of Tarth", "Trial of the Strength")
        );
        List<Knight> knights = List.of(
                new Knight("Jaime Lannister").addTrial(trials.get(0)).addTrial(trials.get(1)),
                new Knight("Brienne of Tarth").addTrial(trials.get(2)).addTrial(trials.get(3))
        );
        TournamentManager tournamentManager = new TournamentManager(knights);
        tournamentManager.startTrials();
    }
}