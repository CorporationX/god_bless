package faang.school.godbless.kingstournament2903;

import java.util.ArrayList;
import java.util.List;

public class King {

    public static void main(String[] args) {
        Knight brienne = new Knight("Brienne of Tarth");
        Knight jorah = new Knight("Jorah Mormont");
        List<Knight> knights = new ArrayList<>(List.of(brienne, jorah));
        createTrialsFor(brienne);
        createTrialsFor(jorah);
        startTrials(knights);
    }

    private static void createTrialsFor(Knight knight) {
        String knightName = knight.getName();
        knight.addTrial(new Trial(knightName, "Search and rescue mission"));
        knight.addTrial(new Trial(knightName, "Agility challenges"));
        knight.addTrial(new Trial(knightName, "Archery competition"));
        knight.addTrial(new Trial(knightName, "Tournament duel"));
    }

    private static void startTrials(List<Knight> knights) {
        for (Knight knight : knights) {
            knight.startTrials();
        }
    }
}
