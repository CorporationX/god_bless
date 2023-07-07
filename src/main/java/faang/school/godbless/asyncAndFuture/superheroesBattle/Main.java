package faang.school.godbless.asyncAndFuture.superheroesBattle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        SuperheroBattle superheroBattle = new SuperheroBattle();

        // Создание супергероев
        Superhero ironMan = new Superhero("Iron Man", 9, 6);
        Superhero captainAmerica = new Superhero("Captain America", 8, 8);
        Superhero thor = new Superhero("Thor", 10, 7);
        Superhero hulk = new Superhero("Hulk", 10, 4);

        // Создание списка пар супергероев
        List<Pair<Superhero, Superhero>> superheroPairs = new ArrayList<>(Arrays.asList(
                new Pair<>(ironMan, captainAmerica),
                new Pair<>(thor, hulk)
        ));

        List<Future<Superhero>> winnersFuturesRecursion = new ArrayList<>();
        while (winnersFuturesRecursion.size() != 1) {
            System.out.println("Новый круг соревнования: ");
            winnersFuturesRecursion = superheroBattle.runCompetitions(superheroPairs);

            Pair<Superhero, Superhero> pair = new Pair<>();
            superheroPairs.clear();

            // Обработка результатов соревнований
            for (int i = 0; i < winnersFuturesRecursion.size(); i++) {
                try {
                    Superhero winner = winnersFuturesRecursion.get(i).get();
                    System.out.println("Победитель соревнования " + (i + 1) + ": " + winner.getName());

                    //Создаем новые пары
                    if (i % 2 == 0) {
                        pair.setFirst(winner);
                    } else {
                        pair.setSecond(winner);
                        superheroPairs.add(pair);
                        pair = new Pair<>();
                    }
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
