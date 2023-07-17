package faang.school.godbless.multithreading.superheroes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CompetitionArena {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SuperheroBattle superheroBattle = new SuperheroBattle();

        List<Pair<Superhero>> superheroPairs = getSuperheroPairs();
        List<Future<Superhero>> winnersFutures;

        while (true) {
            winnersFutures = superheroBattle.runCompetitions(superheroPairs);
            winnersFutures.forEach(future -> {
                try {
                    System.out.println("Победитель соревнования " + future.get().getName());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            });

            if (superheroPairs.size() == 1) {
                break;
            }
            superheroPairs = getNewRandomPairs(winnersFutures);
        }

        superheroBattle.shutdown();
    }

    private static List<Pair<Superhero>> getNewRandomPairs(List<Future<Superhero>> winnersFutures)
            throws ExecutionException, InterruptedException {
        List<Future<Superhero>> winnersFuturesCopy = new ArrayList<>(winnersFutures);
        List<Pair<Superhero>> superheroPairs = new ArrayList<>();

        while (winnersFuturesCopy.size() > 1) {
            int indexFirst = RANDOM.nextInt(winnersFuturesCopy.size());
            Superhero firstWinner = winnersFuturesCopy.get(indexFirst).get();
            winnersFuturesCopy.remove(indexFirst);

            int indexSecond = RANDOM.nextInt(winnersFuturesCopy.size());
            Superhero secondWinner = winnersFuturesCopy.get(indexSecond).get();
            winnersFuturesCopy.remove(indexSecond);

            superheroPairs.add(new Pair<>(firstWinner, secondWinner));
        }

        return superheroPairs;
    }

    private static List<Pair<Superhero>> getSuperheroPairs() {
        Superhero ironMan = new Superhero("Iron Man", 9, 6);
        Superhero captainAmerica = new Superhero("Captain America", 8, 8);
        Superhero thor = new Superhero("Thor", 10, 7);
        Superhero hulk = new Superhero("Hulk", 10, 4);
        Superhero spiderMan = new Superhero("Spider-Man", 6, 10);
        Superhero blackPanther = new Superhero("Black Panther", 5, 9);
        Superhero thanos = new Superhero("Thanos", 13, 5);
        Superhero vision  = new Superhero("Vision", 9, 7);


        return List.of(
                new Pair<>(ironMan, captainAmerica),
                new Pair<>(thor, hulk),
                new Pair<>(spiderMan, blackPanther),
                new Pair<>(vision, thanos)
        );
    }
}
