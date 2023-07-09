package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class SuperheroBattle {
    ExecutorService executor;

    public SuperheroBattle() {
        executor = Executors.newCachedThreadPool();
    }

    public static void main(String[] args) {
        SuperheroBattle superheroBattle = new SuperheroBattle();

        Superhero ironMan = new Superhero("Iron Man", 9, 6);
        Superhero captainAmerica = new Superhero("Captain America", 8, 8);
        Superhero thor = new Superhero("Thor", 10, 7);
        Superhero hulk = new Superhero("Hulk", 10, 4);

        List<HashMap<String, Superhero>> superheroPairs = new ArrayList<>();
        HashMap<String, Superhero> pair1 = new HashMap<>();
        pair1.put("hero1", ironMan);
        pair1.put("hero2", captainAmerica);
        superheroPairs.add(pair1);

        HashMap<String, Superhero> pair2 = new HashMap<>();
        pair2.put("hero1", thor);
        pair2.put("hero2", hulk);
        superheroPairs.add(pair2);

        List<Future<Superhero>> winnersFutures = superheroBattle.runCompetitions(superheroPairs);

        while (winnersFutures.size() > 1) {
            List<HashMap<String, Superhero>> newPairs = new ArrayList<>();

            for (int i = 0; i < winnersFutures.size(); i += 2) {
                try {
                    Superhero hero1 = winnersFutures.get(i).get();
                    Superhero hero2 = winnersFutures.get(i + 1).get();

                    HashMap<String, Superhero> newPair = new HashMap<>();
                    newPair.put("hero1", hero1);
                    newPair.put("hero2", hero2);

                    newPairs.add(newPair);
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }

            winnersFutures = superheroBattle.runCompetitions(newPairs);
        }

        try {
            Superhero winner = winnersFutures.get(0).get();
            System.out.println("The strongest superhero is : " + winner.getName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public List<Future<Superhero>> runCompetitions(List<HashMap<String, Superhero>> superheroPairs) {
        List<Future<Superhero>> winnersFutures = new ArrayList<>();

        for (HashMap<String, Superhero> pair : superheroPairs) {
            Superhero superhero1 = pair.get("hero1");
            Superhero superhero2 = pair.get("hero2");

            Callable<Superhero> competitionTask = () -> {
                int result = calculateResult(superhero1, superhero2);
                return (result == 1) ? superhero1 : superhero2;
            };

            Future<Superhero> winnerFuture = executor.submit(competitionTask);
            winnersFutures.add(winnerFuture);
        }
        return winnersFutures;
    }

    private int calculateResult(Superhero superhero1, Superhero superhero2) {
        if (superhero1.getStrength() > superhero2.getStrength()) {
            return 1;
        } else if (superhero1.getStrength() < superhero2.getStrength()) {
            return 2;
        } else {
            return (new Random().nextInt(2) + 1);
        }
    }
}
