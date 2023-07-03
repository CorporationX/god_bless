package faang.school.godbless.superheroesBattle;

import java.util.*;
import java.util.concurrent.*;

public class SuperheroBattle {
    private final ExecutorService executorService = Executors.newFixedThreadPool(4);

    public List<Future<Superhero>> runCompetitions(List<Map.Entry<Superhero, Superhero>> superheroPairs) {
        List<Future<Superhero>> winnersFutures = new ArrayList<>();

        for (Map.Entry<Superhero, Superhero> pair : superheroPairs) {
            Callable<Superhero> competitionTask = () -> determineWinner(pair.getKey(), pair.getValue());
            Future<Superhero> winnerFuture = executorService.submit(competitionTask);
            winnersFutures.add(winnerFuture);
        }

        return winnersFutures;
    }

    private Superhero determineWinner(Superhero superhero1, Superhero superhero2) {
        return (superhero1.getStrength() > superhero2.getStrength() || (superhero1.getStrength() == superhero2.getStrength() && superhero1.getAgility() > superhero2.getAgility()))
                ? superhero1
                : superhero2;
    }

    public void runTournament(List<Map.Entry<Superhero, Superhero>> superheroPairs) {
        List<Future<Superhero>> winnersFutures = runCompetitions(superheroPairs);

        for (int i = 0; i < winnersFutures.size(); i++) {
            try {
                Superhero winner = winnersFutures.get(i).get();
                System.out.println("Победитель соревнования " + (i + 1) + ": " + winner.getName());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        while (winnersFutures.size() > 1) {
            List<Map.Entry<Superhero, Superhero>> newPairs = formRandomPairs(winnersFutures);
            winnersFutures = runCompetitions(newPairs);

            System.out.println("Новые соревнования:");
            for (int i = 0; i < winnersFutures.size(); i++) {
                try {
                    Superhero winner = winnersFutures.get(i).get();
                    System.out.println("Победитель соревнования " + (i + 1) + ": " + winner.getName());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }

        if (!winnersFutures.isEmpty()) {
            try {
                Superhero finalWinner = winnersFutures.get(0).get();
                System.out.println("Сильнейший герой: " + finalWinner.getName());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
    }

    private List<Map.Entry<Superhero, Superhero>> formRandomPairs(List<Future<Superhero>> winnersFutures) {
        List<Superhero> winners = new ArrayList<>();

        for (Future<Superhero> winnerFuture : winnersFutures) {
            try {
                winners.add(winnerFuture.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        List<Map.Entry<Superhero, Superhero>> newPairs = new ArrayList<>();
        Random random = new Random();

        while (!winners.isEmpty()) {
            int index1 = random.nextInt(winners.size());
            Superhero superhero1 = winners.remove(index1);

            int index2 = random.nextInt(winners.size());
            Superhero superhero2 = winners.remove(index2);

            newPairs.add(new AbstractMap.SimpleEntry<>(superhero1, superhero2));
        }

        return newPairs;
    }

}
