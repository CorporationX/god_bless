package Sprint_4.BJS2_38502;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SuperheroBattle {

    public List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> pairs) {
        ExecutorService executor = Executors.newFixedThreadPool(pairs.size());
        List<Future<Superhero>> results = new ArrayList<>();

        for (Pair<Superhero, Superhero> pair : pairs) {
            Future<Superhero> futureWinner = CompletableFuture.supplyAsync(() -> determineWinner(pair), executor);
            results.add(futureWinner);
        }

        executor.shutdown();
        return results;
    }

    private Superhero determineWinner(Pair<Superhero, Superhero> pair) {
        Superhero hero1 = pair.getFirst();
        Superhero hero2 = pair.getSecond();

        int hero1Score = hero1.getStrength() + hero1.getAgility();
        int hero2Score = hero2.getStrength() + hero2.getAgility();

        return hero1Score >= hero2Score ? hero1 : hero2;
    }
}