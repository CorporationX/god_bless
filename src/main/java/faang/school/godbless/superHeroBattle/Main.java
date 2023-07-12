package faang.school.godbless.superHeroBattle;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        SuperheroBattle superheroBattle = new SuperheroBattle();

// Создание супергероев
        Superhero ironMan = new Superhero("Iron Man", 9, 6, 1000);
        Superhero captainAmerica = new Superhero("Captain America", 5, 8, 1000);
        Superhero thor = new Superhero("Thor", 10, 7, 1000);
        Superhero hulk = new Superhero("Hulk", 15, 4, 1000);

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
                System.out.println("Победитель соревнования " + (i + 1) + ": " + winner.getName());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
