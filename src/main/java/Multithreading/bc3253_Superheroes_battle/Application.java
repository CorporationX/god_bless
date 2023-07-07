package Multithreading.bc3253_Superheroes_battle;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Application {
    public static void main(String[] args) {
        SuperheroBattle superheroBattle = new SuperheroBattle();

// Создание супергероев
        Superhero ironMan = new Superhero("Iron Man", 9, 6);
        Superhero captainAmerica = new Superhero("Captain America", 8, 8);
        Superhero thor = new Superhero("Thor", 10, 7);
        Superhero hulk = new Superhero("Hulk", 10, 4);
        Superhero superMan = new Superhero("SuperMan", 15, 10);
        Superhero spiderMan = new Superhero("SpiderMan", 10, 5);


// Создание списка пар супергероев
        List<Pair<Superhero, Superhero>> superheroPairs = List.of(
                new Pair<>(ironMan, captainAmerica),
                new Pair<>(thor, hulk),
                new Pair<>(superMan, spiderMan)
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
