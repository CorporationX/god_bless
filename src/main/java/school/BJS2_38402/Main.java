package school.BJS2_38402;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {

        List<Superhero> winners = new ArrayList<>();
        SuperheroBattle superheroBattle = new SuperheroBattle();

// Создание супергероев
        Superhero ironMan = new Superhero("Iron Man", 9, 6);
        Superhero captainAmerica = new Superhero("Captain America", 8, 8);
        Superhero thor = new Superhero("Thor", 10, 7);
        Superhero hulk = new Superhero("Hulk", 10, 4);

// Создание списка пар супергероев
        List<Pair<Superhero, Superhero>> superheroPairs = Arrays.asList(
                new Pair<>(ironMan, captainAmerica),
                new Pair<>(thor, hulk)
        );

// Запуск серии соревнований
        List<Future<Superhero>> winnersFutures = superheroBattle.runCompetitions(superheroPairs);

// Обработка результатов соревнований
        for (int i = 0; i < winnersFutures.size(); i++) {
            try {
                Superhero winner = winnersFutures.get(i).get();
                winners.add(winner);
                System.out.println("Победитель соревнования " + (i + 1) + ": " + winner.getName());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        List<Pair<Superhero, Superhero>> superheroWinnerPairs = new ArrayList<>();
        if (winners.size() % 2 == 0) {
            for (int i = 0; i < winners.size(); ) {
                for (int j = i + 1; j < winners.size(); j++) {
                    Superhero winner = winners.get(i);
                    Superhero winner2 = winners.get(j);
                    superheroWinnerPairs.add(new Pair<>(winner, winner2));
                }
                i = i + 2;
            }
        }
        List<Future<Superhero>> winnersFuturesGlobal = superheroBattle.runCompetitions(superheroWinnerPairs);

        for (int i = 0; i < winnersFuturesGlobal.size(); i++) {
            try {
                Superhero winner = winnersFuturesGlobal.get(i).get();
                System.out.println("Победитель из победителей соревнования " + (i + 1) + ": " + winner.getName());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
