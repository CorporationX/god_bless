package faang.school.godbless.super_heroes_battle;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        SuperHeroBattle superHeroBattle = new SuperHeroBattle();

        SuperHero ironMan = new SuperHero("Iron Man", 9, 6);
        SuperHero captainAmerica = new SuperHero("Captain America", 8, 8);
        SuperHero thor = new SuperHero("Thor", 10, 7);
        SuperHero hulk = new SuperHero("Hulk", 10, 4);

        List<Pair> pairs = List.of(new Pair(ironMan, captainAmerica), new Pair(thor, hulk));

        List<Future<SuperHero>> winnersFutures = superHeroBattle.runCompetitions(pairs);

        for (int i = 0; i < winnersFutures.size(); i++) {
            try {
                SuperHero winner = winnersFutures.get(i).get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
