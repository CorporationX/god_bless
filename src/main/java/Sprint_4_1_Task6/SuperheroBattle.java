package Sprint_4_1_Task6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SuperheroBattle {
    public List<Future<Superhero>> runCompetitions(List<Pair> competitions) {
        ExecutorService executor = Executors.newFixedThreadPool(competitions.size());
        List<Future<Superhero>> winnersFutures = new ArrayList<>();
        for (Pair competition : competitions) {
            Future<Superhero> future = executor.submit(() -> {
                if (competition.getLeft().getStrength() > competition.getRight().getStrength()) {
                    return competition.getLeft();
                } else
                    return competition.getRight();
            });
            winnersFutures.add(future);
        }
        executor.shutdown();
        return winnersFutures;
    }

    public static void main(String[] args) {
        SuperheroBattle superheroBattle = new SuperheroBattle();

        // Создание супергероев
        Superhero ironMan = new Superhero("Iron Man", 9, 6);
        Superhero captainAmerica = new Superhero("Captain America", 8, 8);
        Superhero thor = new Superhero("Thor", 10, 7);
        Superhero hulk = new Superhero("Hulk", 10, 4);

        // Создание списка пар супергероев
        List<Pair> superheroPairs = Arrays.asList(
                new Pair(ironMan, captainAmerica),
                new Pair(thor, hulk)
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
