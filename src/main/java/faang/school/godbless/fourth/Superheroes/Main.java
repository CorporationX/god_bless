package faang.school.godbless.fourth.Superheroes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        SuperheroBattle superheroBattle = new SuperheroBattle();

        Superhero ironMan = new Superhero("Iron Man", 9, 6);
        Superhero captainAmerica = new Superhero("Captain America", 8, 7);
        Superhero thor = new Superhero("Thor", 10, 5);
        Superhero hulk = new Superhero("Hulk", 10, 4);
        Superhero spiderMan = new Superhero("Spider-Man", 7, 8);
        Superhero daredevil = new Superhero("Daredevil", 5, 10);
        Superhero deadpool = new Superhero("Deadpool", 4, 11);
        Superhero wolverine = new Superhero("Wolverine", 9, 6);

        List<Pair> superheroPairs = Arrays.asList(
                new Pair(ironMan, captainAmerica),
                new Pair(thor, hulk),
                new Pair(spiderMan, daredevil),
                new Pair(deadpool, wolverine)
        );

        List<Future<Superhero>> winnersFutures = superheroBattle.runCompetitions(superheroPairs);
        int circle = 1;

        while (true) {
            System.out.println("Стартует " + circle++ + " круг соревнования");
            List<Superhero> winners = new ArrayList<>();
            superheroPairs = new ArrayList<>();

            for (int i = 0; i < winnersFutures.size(); i++) {
                try {
                    Superhero winner = winnersFutures.get(i).get();
                    winners.add(winner);
                    System.out.println("Победитель соревнования " + (i + 1) + ": " + winner.name());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }

            if (winners.size() > 1) {
                for (int i = 0; i < winners.size(); i += 2) {
                    superheroPairs.add(new Pair(winners.get(i), winners.get(i + 1)));
                }
                winnersFutures = superheroBattle.runCompetitions(superheroPairs);
            } else {
                System.out.println("Cоревнования завершены.");
                return;
            }
        }
    }
}
