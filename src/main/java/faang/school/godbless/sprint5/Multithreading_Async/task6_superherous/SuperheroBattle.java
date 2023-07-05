package faang.school.godbless.sprint5.Multithreading_Async.task6_superherous;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SuperheroBattle {

    public static List<Future<Superhero>> runCompetitions(List<Pair> pairs) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Future<Superhero>> futures = new ArrayList<>();
        for (Pair pair : pairs) {
            Future<Superhero> futureSuperhero = executor.submit(
                    () -> battleSuperhero(pair.getSuperhero1(), pair.getSuperhero2()));
            futures.add(futureSuperhero);
        }
        executor.shutdown();
        return futures;
    }

    @SneakyThrows
    public static void main(String[] args) {

        // Создание супергероев
        Superhero ironMan = new Superhero("Iron Man", 18, 12);
        Superhero captainAmerica = new Superhero("Captain America", 8, 8);
        Superhero thor = new Superhero("Thor", 10, 7);
        Superhero hulk = new Superhero("Hulk", 10, 4);
        Superhero spiderMan = new Superhero("Spider Man", 12, 5);
        Superhero blackWidow = new Superhero("Black Widow", 5, 8);
        Superhero captainMarvel = new Superhero("Captain Marvel", 15, 12);
        Superhero vision = new Superhero("Vision", 12, 12);

        // Создание списка пар супергероев
        List<Pair> superheroPairs = Arrays.asList(
                new Pair(ironMan, captainAmerica),
                new Pair(thor, hulk),
                new Pair(spiderMan, blackWidow),
                new Pair(captainMarvel, vision)

        );

        List<Future<Superhero>> futures = battleToDie(superheroPairs);

        System.out.println("Победитель: " + futures.get(0).get().getName());

        // Запуск серии соревнований
        List<Future<Superhero>> winnersFutures = runCompetitions(superheroPairs);

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

    @SneakyThrows
    private static List<Future<Superhero>> battleToDie(List<Pair> superheroPairs) {
        List<Future<Superhero>> winnersFutures = SuperheroBattle.runCompetitions(superheroPairs);

        if (winnersFutures.size() == 1) {
            return winnersFutures;
        }
        List<Superhero> winners = new ArrayList<>();
        for (Future<Superhero> winnersFuture : winnersFutures) {
            Superhero winner = winnersFuture.get();
            winners.add(winner);
        }
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < winners.size(); i += 2) {
            Pair pair = new Pair(winners.get(i), winners.get(i + 1));
            pairs.add(pair);
        }
        return battleToDie(pairs);
    }

    private static Superhero battleSuperhero(Superhero superhero1, Superhero superhero2) {
        int countSuperhero1 = superhero1.getAgility() + superhero1.getStrength();
        int countSuperhero2 = superhero2.getAgility() + superhero2.getStrength();
        if (countSuperhero1 > countSuperhero2) {
            return superhero1;
        } else if (countSuperhero2 > countSuperhero1) {
            return superhero2;
        } else {
            return null;
        }
    }
}
