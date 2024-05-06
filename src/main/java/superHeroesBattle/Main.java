package superHeroesBattle;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        SuperheroBattle battle = new SuperheroBattle();

        Superhero superhero1 = new Superhero("Hero 1", 10, 10);
        Superhero superhero2 = new Superhero("Hero 2", 15, 10);
        Superhero superhero3 = new Superhero("Hero 3", 15, 10);
        Superhero superhero4 = new Superhero("Hero 4", 10, 10);

        Pair pair1 = new Pair(superhero1, superhero2);
        Pair pair2 = new Pair(superhero3, superhero4);

        List<Pair> pairs = List.of(pair1, pair2);

        battle.runCompetitions(pairs).forEach(winner -> {
            try {
                System.out.println("Winner in pair: " + winner.get().getName());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

        battle.shutdown();

    }
}
