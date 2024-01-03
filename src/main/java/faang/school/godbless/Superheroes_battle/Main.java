package faang.school.godbless.Superheroes_battle;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
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
        List<CompletableFuture<Superhero>> winnersFutures = superheroBattle.runCompetitions(superheroPairs);
// Выводим победителя
        winnersFutures.forEach(future -> {
            try {
                System.out.println(future.get().getName() + " is the winner");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
