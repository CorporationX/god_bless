package faang.school.godbless.spring_4.superheroes_battle;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {

        SuperheroBattle battle = new SuperheroBattle();

        Superhero ironMan = new Superhero("Iron Man", 9, 6);
        Superhero captainAmerica = new Superhero("Captain America", 8, 8);
        Superhero thor = new Superhero("Thor", 10, 7);
        Superhero hulk = new Superhero("Hulk", 10, 4);

        List<Pair> superheroPairs = new ArrayList<>() {{
            add(new Pair(ironMan, captainAmerica));
            add(new Pair(thor, hulk));
        }};

        List<Future<Superhero>> winnersFutures = battle.runCompetitions(superheroPairs);

        int i = 1;
        for (Future<Superhero> winnersFuture : winnersFutures) {
            try {
                Superhero winner = winnersFuture.get();
                System.out.println("The winner of the competition " + (i++) + ": " + winner.getName());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
