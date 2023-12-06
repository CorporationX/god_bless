package faang.school.godbless.superhero_battle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SuperheroBattle {

    static List<Superhero> draw = new ArrayList<>();
    static List<Superhero> nextRoundList = new ArrayList<>();
    static List<Pair<Superhero>> superheroPairs;

    static {
        Superhero ironMan = new Superhero("Iron Man", 9, 6);
        Superhero captainAmerica = new Superhero("Captain America", 8, 8);
        Superhero thor = new Superhero("Thor", 10, 7);
        Superhero hulk = new Superhero("Hulk", 10, 4);
        Superhero blackPanther = new Superhero("Black Panther", 10, 8);
        Superhero doctorStrange = new Superhero("Doctor Strange", 9, 8);
        Superhero blackWidow = new Superhero("Black Widow", 10, 8);
        Superhero batman = new Superhero("Batman", 10, 10);

        superheroPairs = Arrays.asList(
                new Pair<>(ironMan, captainAmerica),
                new Pair<>(thor, hulk),
                new Pair<>(blackWidow, doctorStrange),
                new Pair<>(blackPanther, batman)
        );
    }

    public static void main(String[] args) {
        startBattle(superheroPairs);
    }

    public static List<Future<Superhero>> runCompetitions(List<Pair<Superhero>> pairs){
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Future<Superhero>> results = new ArrayList<>();
        for (Pair<Superhero> pair : pairs){
            Future<Superhero> result = executorService.submit(
                    () -> getWinner(pair.getFirst(), pair.getSecond()).orElse(null));
            results.add(result);
        }

        executorService.shutdown();
        return results;
    }

    private static void startBattle(List<Pair<Superhero>> pairs){
        List<Future<Superhero>> winnersFutures = SuperheroBattle.runCompetitions(pairs);
        printWinners(winnersFutures);
        if (nextRoundList.size() >= 2){
            System.out.println("Next round");
            startBattle(formNewPairs(nextRoundList));
        }
    }

    private static Optional<Superhero> getWinner(Superhero superhero1, Superhero superhero2){
        if ((superhero1.getStrength() * superhero1.getAgility()) -
                (superhero2.getStrength() * superhero2.getAgility()) > 0){
            return Optional.of(superhero1);
        } else if ((superhero1.getStrength() * superhero1.getAgility()) -
                (superhero2.getStrength() * superhero2.getAgility()) < 0){
            return Optional.of(superhero2);
        } else {
            draw.add(superhero1);
            draw.add(superhero2);
            return Optional.ofNullable(null);
        }
    }

    private static List<Pair<Superhero>> formNewPairs(List<Superhero> list){
        List<Pair<Superhero>> pairs = new ArrayList<>();
        int size = list.size() % 2 == 0 ? list.size() : (list.size() - 1);

        for (int i = 0; i < size; i += 2){
            Superhero superhero1 = list.get(i);
            Superhero superhero2 = list.get(i+1);
            pairs.add(new Pair<>(superhero1, superhero2));
        }

        return pairs;
    }

    private static void printWinners(List<Future<Superhero>> winnersFutures){
        nextRoundList.clear();
        for (int i = 0; i < winnersFutures.size(); i++) {
            try {
                if (winnersFutures.get(i).get() != null){
                    Superhero winner = winnersFutures.get(i).get();
                    nextRoundList.add(winner);
                    System.out.println("Победитель соревнования " + (i + 1) + ": " + winner.getName());
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}