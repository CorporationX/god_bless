package school.faang.superheroes_battle_BJS2_38409;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {

        Superhero ironMan = new Superhero("Iron Man", 9, 6);
        Superhero captainAmerica = new Superhero("Captain America", 8, 8);
        Superhero thor = new Superhero("Thor", 10, 7);
        Superhero hulk = new Superhero("Hulk", 10, 4);
        Superhero blackWidow = new Superhero("Black Widow", 7, 8);
        Superhero doctorStrange = new Superhero("Doctor Strange", 9, 8);

        List<Pair> superheroPairs = new ArrayList<>(List.of(
                new Pair(ironMan, captainAmerica),
                new Pair(blackWidow, doctorStrange),
                new Pair(thor, hulk)
        ));

        SuperheroBattle superheroBattle = new SuperheroBattle();
        Future<Superhero> winnerFuture = superheroBattle.runCompetitions(superheroPairs);

        superheroBattle.getExecutor().shutdown();
        try {
            System.out.println("Ultimate winner: " + winnerFuture.get().getName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}