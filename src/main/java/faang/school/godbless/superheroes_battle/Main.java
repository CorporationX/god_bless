package faang.school.godbless.superheroes_battle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        SuperheroBattle superheroBattle = new SuperheroBattle();
        Superhero ironMan = new Superhero("Железный человек", 9, 6);
        Superhero captainAmerica = new Superhero("Капитан Америка", 8, 8);
        Superhero thor = new Superhero("Тор", 10, 7);
        Superhero hulk = new Superhero("Халк", 10, 4);

        Map<Superhero, Superhero> superheroPairs = new HashMap<>();
        superheroPairs.put(ironMan, captainAmerica);
        superheroPairs.put(thor, hulk);
        List<Future<Superhero>> winnerFuture = superheroBattle.runCompetitions(superheroPairs);
        for (int i = 0; i < winnerFuture.size(); i++) {
            try {
                Superhero winner = winnerFuture.get(i).get();
                System.out.println("Победитель схватки: " + (i + 1) + ": " + winner.getName());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        superheroBattle.shutdownExecutorService();
    }
}
