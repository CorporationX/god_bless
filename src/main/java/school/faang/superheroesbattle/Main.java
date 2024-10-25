package school.faang.superheroesbattle;


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

        superheroBattle.shutdown();
    }

    public static class Pair<F, S> {
        private final F first;
        private final S second;

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        public F getFirst() {
            return first;
        }

        public S getSecond() {
            return second;
        }
    }
}
